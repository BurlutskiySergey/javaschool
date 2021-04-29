package ru.sber.javaschool.processing;

import lombok.AllArgsConstructor;
import ru.sber.javaschool.account.Account;
import ru.sber.javaschool.card.Card;
import ru.sber.javaschool.client.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@AllArgsConstructor
public class Processing {
    /** Список клиентов */
    private List<Client> clients;

    /**
     * Вернуть данные счёта клиента
     * @param cardNum - номер карты
     * @return возвращает счёт клиента
     */
    public Account<?> getAccountData(String cardNum) throws ProcessingException {
        Client client = findClient(cardNum);
        return findAccount(client, cardNum);
    }

    /**
     * Проверить данные карты
     * @param cardNum - номер карты
     * @param pinCode - пин-код карты
     */
    public void checkCardData(String cardNum, int pinCode) throws ProcessingException {
        validateCardNum(cardNum);
        validatePinCode(pinCode);
        Account<?> account = getAccountData(cardNum);
        Card card = account.findCard(cardNum);
        validateExpiredDate(card.getExpiredDate());
    }

    /**
     * Проверить правильность введёного пин-кода
     * @param cardPinCode - пин-код карты
     * @param pinCode - введённый пин-код
     */
    public void checkPinCode(int cardPinCode, int pinCode) throws ProcessingException {
        if (cardPinCode != pinCode)
            throw new ProcessingException("введён не верный пин-код");
    }

    /**
     * Проверить номер карты
     * @param cardNum - номер карты
     */
    private void validateCardNum(String cardNum) throws ProcessingException {
        if (!Pattern.matches("\\d{16}", cardNum))
            throw new ProcessingException("невалидный номер карты");
    }

    /**
     * Проверить пин-код карты
     * @param pinCode - пин-код карты
     */
    private void validatePinCode(int pinCode) throws ProcessingException {
        if (!Pattern.matches("\\d{3}", Integer.toString(pinCode)))
            throw new ProcessingException("невалидный пин-код");
    }

    /**
     * Проверить пин-код карты
     * @param expiredDate - срок истечения карты
     */
    private void validateExpiredDate(LocalDate expiredDate) throws ProcessingException {
        if (expiredDate.compareTo(LocalDate.now()) < 0)
            throw new ProcessingException("срок действия карты истёк");
    }

    /**
     * Найти клиента
     * @param cardNum - номер карты
     */
    private Client findClient(String cardNum) throws ProcessingException {
        return clients.stream().filter(c -> c.findAccount(cardNum).isPresent()).findFirst().
                orElseThrow(() -> new ProcessingException("отсутствуют данные о карте"));
    }

    /**
     * Найти счёт клиента
     * @param client - клиент
     * @param cardNum - номер карты
     */
    private Account<?> findAccount(Client client, String cardNum) throws ProcessingException {
        return client.findAccount(cardNum).orElseThrow(() -> new ProcessingException("не найден счёт для переданного номера карты"));
    }
}
