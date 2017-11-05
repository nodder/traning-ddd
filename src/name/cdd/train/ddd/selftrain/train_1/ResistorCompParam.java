package name.cdd.train.ddd.selftrain.train_1;

import name.cdd.train.ddd.selftrain.train_1.UnaryParams.CardType;

public class ResistorCompParam
{
    public CardType cardType;
    public float rab;
    public float rag;
    public float rbg;
    
    public ResistorCompParam(CardType cardType, float rab, float rag, float rbg)
    {
        this.cardType = cardType;
        this.rab = rab;
        this.rag = rag;
        this.rbg = rbg;
    }
    
}
