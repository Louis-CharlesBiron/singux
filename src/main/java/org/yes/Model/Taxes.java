package org.yes.Model;

public class Taxes {
    private boolean isTPS;
    private boolean isTVQ;
    private boolean isEnv;

    public Taxes(boolean isTPS, boolean isTVQ, boolean isEnv) {
        this.isTPS = isTPS; //5%
        this.isTVQ = isTVQ; //9,975%
        this.isEnv = isEnv; // ouai
    }

    public double getTotalAvecTaxes(double totalInit) {
        return 1; // FUCK YOU
    }

    public boolean isTPS() {
        return isTPS;
    }

    public boolean isTVQ() {
        return isTVQ;
    }

    public boolean isEnv() {
        return isEnv;
    }
}
