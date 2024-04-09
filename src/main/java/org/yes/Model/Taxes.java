package org.yes.Model;

public class Taxes {
    private boolean isTPS;
    private boolean isTVQ;
    private boolean isEnv;

    public Taxes(boolean isTPS, boolean isTVQ, boolean isEnv) {
        this.isTPS = isTPS;
        this.isTVQ = isTVQ;
        this.isEnv = isEnv;
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
