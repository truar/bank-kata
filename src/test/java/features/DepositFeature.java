package features;

import com.zenikata.bank.domain.BankAccount;
import com.zenikata.bank.domain.SGBankAccount;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositFeature {

    private BankAccount bankAcount;

    @Given("^A client with 0 into his bank account$")
    public void initAccount() {
        bankAcount = new SGBankAccount();
    }

    @When("^He deposits \"([^\"]*)\" into his bank account$")
    public void depositMoneyIntoAccount(Integer amountToDepose) {
        bankAcount.deposit(amountToDepose);
    }

    @Then("^His new balance is \"([^\"]*)\"")
    public void verifyRunningBalance(Integer expectedBalance) {
        assertThat(bankAcount.balance()).isEqualTo(expectedBalance);
    }

}
