package features;

import com.zenikata.bank.domain.BankAccount;
import com.zenikata.bank.domain.Clock;
import com.zenikata.bank.domain.Money;
import com.zenikata.bank.domain.SGBankAccount;
import com.zenikata.bank.presenter.StringReporter;
import com.zenikata.bank.presenter.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAccountDefinitionStep {

    private BankAccount bankAccount;

    private Reporter reporter = new StringReporter();

    private Clock clock;

    private final static LocalDateTime dateTime = LocalDateTime.of(2019, 02, 02, 14, 5, 30);

    @Given("^A client creates his bank account$")
    public void initAccount() {
        clock = mock(Clock.class);
        when(clock.now()).thenReturn(dateTime);
        bankAccount = new SGBankAccount(clock);
    }

    @Given("^A client with \"([^\"]*)\" into his bank account$")
    public void initAccountWithDeposit(Integer initialAmount) {
        initAccount();
        bankAccount.deposit(Money.fromInteger(initialAmount));
    }

    @When("^He deposits \"([^\"]*)\" into his bank account$")
    public void depositMoneyIntoAccount(Integer amountToDepose) {
        bankAccount.deposit(Money.fromInteger(amountToDepose));
    }

    @When("^He withdraws \"([^\"]*)\" from his bank account$")
    public void WithdrawMoneyFromAccount(Integer amountToWithdraw) {
        bankAccount.withdraw(Money.fromInteger(amountToWithdraw));
    }

    @Then("^His new balance is \"([^\"]*)\"")
    public void verifyRunningBalance(Integer expectedBalance) {
        assertThat(bankAccount.balance()).isEqualTo(new BigDecimal(expectedBalance));
    }

    @Then("^His report displays")
    public void verifyReportDisplay(String report) {
        assertThat(reporter.print(bankAccount)).isEqualTo(report);
    }

}
