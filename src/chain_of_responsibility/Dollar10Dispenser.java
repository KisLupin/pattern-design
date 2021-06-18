package chain_of_responsibility;

public class Dollar10Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 10) {
            int num = cur.getAmount() / 10;
            System.out.println("Dispensing " + num + " 10$ note");
        } else {
            this.chain.dispense(cur);
        }
    }
}
