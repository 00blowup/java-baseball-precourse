package baseball.vo;

public class Answer {

    private final int hundredsDigit;
    private final int tensDigit;
    private final int unitDigit;

    public Answer (int hundredsDigit, int tensDigit, int unitDigit) {
        this.hundredsDigit = hundredsDigit;
        this.tensDigit = tensDigit;
        this.unitDigit = unitDigit;
    }

    public int getHundredsDigit () {
        return hundredsDigit;
    }

    public int getTensDigit () {
        return tensDigit;
    }

    public int getUnitDigit () {
        return unitDigit;
    }
}
