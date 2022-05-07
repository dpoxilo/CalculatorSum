package StepDefinition;

import Calculator.Calculator;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

public class StepDefinition {
    private Calculator calc;

    double a;
    double b;
    double result;

    @Дано("^две цифры (\\d) и (\\d)")
    public void given(double a, double b) {
        this.a = a;
        this.b = b;
        this.calc = new Calculator();
    }

    @Когда("^ищем сумму двух цифр")
    public void when() {
        result = calc.sum(a, b);
    }

    @Тогда("^результат должен быть (\\d)")
    public void then(double res) {
        Assert.assertEquals("Ошибка, сумма двух цифр не верна", res, result, 0.0001);
    }
}
