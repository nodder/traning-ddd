package name.cdd.train.ddd.selftrain.train_1;

public class UnaryParams
{
    public enum CardType
    {
        ALCI, ALCH, Other
    }
    
    public CardType cardType;
    public boolean isEconRelay;//�Ƿ�ʡ�̵���
    
    public UnaryParams(boolean isEconRelay, CardType cardType)
    {
        this.isEconRelay = isEconRelay;
        this.cardType = cardType;
    }
}
