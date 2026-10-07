//MOOC Final OOPS intro Assignment
// 
public class Card {
    private double balance;

    public Card(double openingBalance) {
        balance = openingBalance;
    }

    public void balance() {
        System.out.println("Current Balance: " + this.balance);
    }

    public void eatAffordibly() {
        if (this.balance - 2.60 >= 0) {
            this.balance = this.balance - 2.60;
        } else {
            System.out.println("sorry sleep hungry today");
        }
    }

    public void eatHeartily() {
        if (this.balance - 4.60 >= 0) {
            this.balance = this.balance - 4.60;
        } else {
            System.out.println("sorry sleep hungry today");
        }
    }

    public void addMoney(double addedMoney) {
        if (addedMoney < 0) {
            return;
        }

        if (this.balance + addedMoney > 150) {
            this.balance = 150;
        } else {
            this.balance = this.balance + addedMoney;
        }
    }
}


//upload on github tomorrow