package ComposedClassesEntities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Contract {

    private Integer contractNumber;
    private Date purchaseDate;
    private Double totalValue;

    List<Installment>installments=new ArrayList<Installment>();

    public Contract() {
    }

    public Contract(Integer contractNumber, Date purchaseDate, Double totalValue) {
        this.contractNumber = contractNumber;
        this.purchaseDate = purchaseDate;
        this.totalValue = totalValue;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "\nContract Number=" + contractNumber +
                "\n, Purchase Date=" + purchaseDate +
                "\n, Total Value=" + String.format("%.2f"+"€", totalValue)+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        return getContractNumber().equals(contract.getContractNumber()) &&
                getPurchaseDate().equals(contract.getPurchaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContractNumber(), getPurchaseDate());
    }
}
