package java8.ex06;

import java.util.Objects;
import java.util.function.Supplier;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java8.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// tag::formatAge[]
	// TODO compléter la méthode
	// TODO la méthode retourne une chaîne de caractères de la forme [age=<AGE>]
	// (exemple : [age=12])
	String formatAge(Supplier<Person> supplier) {
		String result = "[age=" + supplier.get().getAge() + "]";
		return result;
	}
	// end::formatAge[]

	@Test
	public void test_supplier_formatAge() throws Exception {
		// TODO compléter le test unitaire pour qu'il soit passant
		String result = formatAge(() -> new Person("x", "y", 35, "osef"));

		assert result.equals("[age=35]");
	}

	@Test
	public void test_supplier_requireNonNull() throws Exception {

		expectedException.expect(NullPointerException.class);
		expectedException.expectMessage("require non null object");

		// TODO compléter le test unitaire pour qu'il soit passant
		Supplier<String> supplier = () -> "require non null object";

		// Avec un paramètre null, cette méthode déclenche un NullPointerException
		Objects.requireNonNull(null, supplier);

	}

}
