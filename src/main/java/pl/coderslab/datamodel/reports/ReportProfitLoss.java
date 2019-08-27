package pl.coderslab.datamodel.reports;

public class ReportProfitLoss {

    private double incomeGross;
    private double partsCostNet;
    private double wagesNet;
    private double incomeNet;

    public ReportProfitLoss() {
    }

    public ReportProfitLoss(double incomeGross, double partsCostNet, int wagesNet, int incomeNet) {
        this.incomeGross = incomeGross;
        this.partsCostNet = partsCostNet;
        this.wagesNet = wagesNet;
        this.incomeNet = incomeNet;
    }

    public double getIncomeGross() {
        return incomeGross;
    }

    public void setIncomeGross(double incomeGross) {
        this.incomeGross = incomeGross;
    }

    public double getPartsCostNet() {
        return partsCostNet;
    }

    public void setPartsCostNet(double partsCostNet) {
        this.partsCostNet = partsCostNet;
    }

    public double getWagesNet() {
        return wagesNet;
    }

    public void setWagesNet(double wagesNet) {
        this.wagesNet = wagesNet;
    }

    public double getIncomeNet() {
        return incomeNet;
    }

    public void setIncomeNet(double incomeNet) {
        this.incomeNet = incomeNet;
    }
}
