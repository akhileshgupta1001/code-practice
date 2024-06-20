/*
package com;

import java.util.Date;
import java.util.List;

class IntrestRateCondition{
    Date startDate;
    Date endDate;

    double rate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate =
                startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate =
                endDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate =
                rate;
    }
}

class LoanCalculation{
    private double amount;
    private List<IntrestRateCondition>
            intrestRateConditionList;

    private double maxCap;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount =
                amount;
    }

    public List<IntrestRateCondition> getIntrestRateConditionList() {
        return intrestRateConditionList;
    }

    public void setIntrestRateConditionList(List<IntrestRateCondition> intrestRateConditionList) {
        this.intrestRateConditionList =
                intrestRateConditionList;
    }

    public double getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(double maxCap) {
        this.maxCap =
                maxCap;
    }
}


public class IntrestRateCalculation {

    public double simpleRateCalculation(LoanCalculation loanCalculation,Date start, Date end){
        IntrestRateCondition intrestRateCondition= loanCalculation.getIntrestRateConditionList().get(0);
         int numberOfDays = start.getDay()-end.getDay();
        return loanCalculation.getAmount() * (numberOfDays+1) * (intrestRateCondition.getRate()/365);
    }

    public double overLappingRateCalculation(LoanCalculation loanCalculation){
        double maxCap = loanCalculation.getMaxCap();
        double totalAmount =0;
       for(int start =1;start<loanCalculation.getIntrestRateConditionList().size();start++){
           // check overlapping

           if(loanCalculation.getIntrestRateConditionList().get(start).getStartDate().compareTo(loanCalculation.getIntrestRateConditionList().get(start-1).getEndDate())<-1){
                maxCap=maxCap- loanCalculation.getIntrestRateConditionList().get(start-1).getRate();
                double amount = simpleRateCalculation(loanCalculation,loanCalculation.getIntrestRateConditionList().get(start-1).getStartDate(),loanCalculation.getIntrestRateConditionList().get(start-1).getEndDate());
            }
       }

    }

    public double intrestRateCalculation(LoanCalculation loanCalculation){
        // Normal cases
        if(loanCalculation.getIntrestRateConditionList().size()==1){
            return simpleRateCalculation(loanCalculation,loanCalculation.getIntrestRateConditionList().get(0).getStartDate(),loanCalculation.getIntrestRateConditionList().get(0).getEndDate());
        }
         // Overlapping cases
        //         // second period of startDate >  first period of startDate
        else if(loanCalculation.getIntrestRateConditionList().size()>1){

        }



        // maxCap Cases
    }

}
*/
