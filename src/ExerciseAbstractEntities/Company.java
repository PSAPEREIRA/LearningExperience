package ExerciseAbstractEntities;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    public Company() {
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double taxTotal() {

        if (numberOfEmployees >= 10) {
            return getAnnualIncome() * 0.14;
        } else {
            return getAnnualIncome() * 0.16;
        }
    }
    @Override
    public String toTaxPayerString() {
        return getName() +':'+ String.format("%.2f",taxTotal())+"€";
    }
}

