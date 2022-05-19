package src.Model;

//The regiser class is responsible for keeping track of the balance stores in the register
public class Register {
    private double registerBalance;

    //The constructor
    public Register(){
        this.registerBalance = 0;
    }

    //returns current register balance
    public double getRegisterBalance() {
        return registerBalance;
    }

    //updates the register balance
    public void updateRegisterBalance(Payment payment){
        registerBalance = registerBalance+payment.getTotalAmount();
    }

}
