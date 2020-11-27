package Services;

import ComposedClassesEntities.Contract;
import ComposedClassesEntities.Installment;
import Interfaces.OnlinePaymentService;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService=onlinePaymentService;
    }

    public void processContract(Contract contract,int months){

        double basicQuota = contract.getTotalValue()/months;

        for (int month=1;month<=months;month++){
            double updateQuota= basicQuota + onlinePaymentService.interest(basicQuota,month);
            double totalQuota= updateQuota+ onlinePaymentService.paymentFee(updateQuota);
            Date dueDate = addMonths(contract.getPurchaseDate(),month);
            contract.getInstallments().add(new Installment(dueDate,totalQuota));
        }
    }

    private Date addMonths(Date date,int nrOfMonths){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,nrOfMonths);
        return calendar.getTime();
    }
}
