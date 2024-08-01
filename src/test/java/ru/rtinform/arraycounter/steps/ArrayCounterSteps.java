package ru.rtinform.arraycounter.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.rtinform.arraycounter.service.ArrayService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayCounterSteps {
    private String input;
    private Map<String, Long> result;
    private final ArrayService arrayService = new ArrayService();

    @Given("входящая строка {string}")
    public void theInputStringIs(String inputString) {
        this.input = inputString;
    }

    @When("я считаю элементы")
    public void iCountTheElements() {
        this.result = arrayService.countElements(input);
    }

    @Then("результат должен быть:")
    public void theResultShouldBe(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        assertEquals(rows.size(), result.size());

        for (Map<String, String> row : rows) {
            String element = row.get("Element");
            Long count = Long.parseLong(row.get("Count"));
            assertEquals(count, result.get(element));
        }
    }

    @Then("результат должен быть пустым")
    public void theResultShouldBeEmpty() {
        assertTrue(result.isEmpty());
    }
}