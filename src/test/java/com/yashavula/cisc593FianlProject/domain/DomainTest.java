package com.yashavula.cisc593FianlProject.domain;


import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.TestClassMustBeProperlyNamedRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

public class DomainTest {	
	
	private static final String  DOAMIN_PACKAGE = "com.yashavula.cisc593FianlProject.domain";
	
	@Test
	public void validateBase() {
		
		Validator validator = ValidatorBuilder.create().with(new GetterTester()).with(new SetterTester())
				.with(new NoStaticExceptFinalRule()).with(new NoPublicFieldsExceptStaticFinalRule())
				.with(new TestClassMustBeProperlyNamedRule()).build();
		
		validator.validate(DOAMIN_PACKAGE);
		
	}

}
