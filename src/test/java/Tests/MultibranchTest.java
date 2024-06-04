package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultibranchTest {
	
	@Test(groups = "regression")
	public void buidingTheProject() {
		Assert.assertTrue(true);
	}

	@Test(groups = "regression")
	public void measuringPerformance() {
		Assert.assertTrue(true);
	}
	@Test(groups ="featurelevel")
	public void checkExecutionTestResults() {
		Assert.assertTrue(true);
	}
	@Test(groups ="featurelevel")
	public void acceptanceTestsCheck() {
		Assert.assertTrue(true);
	}
}
