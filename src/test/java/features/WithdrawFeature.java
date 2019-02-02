package features;

import com.zenikata.bank.domain.BankAccount;
import com.zenikata.bank.domain.SGBankAccount;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class WithdrawFeature {

    private BankAccount bankAcount;

    @Given("^A client with \"([^\"]*)\" into his bank account$")
    public void initAccount(Integer initialAmount) {
        bankAcount = new SGBankAccount();
        bankAcount.deposit(initialAmount);
    }

    @When("^He withdraws \"([^\"]*)\" from his bank account$")
    public void WithdrawMoneyFromAccount(Integer amountToWithdraw) {
        bankAcount.withdraw(amountToWithdraw);
    }

    @Then("^His new balance after the withdraw is \"([^\"]*)\"")
    public void verifyRunningBalance(Integer expectedBalance) {
        assertThat(bankAcount.balance()).isEqualTo(expectedBalance);
    }

}
