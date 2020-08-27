package ExerciseAbstractEntities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual() {
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double taxTotal() {
        if (getAnnualIncome() < 20000.00) {
            return (getAnnualIncome() * 0.15) - (healthExpenditures * 0.50);
        } else {
            return (getAnnualIncome() * 0.25) - (healthExpenditures * 0.50);
        }
    }

    @Override
    public String toTaxPayerString() {
        return getName() +':'+ String.format("%.2f",taxTotal())+"€";
    }
}