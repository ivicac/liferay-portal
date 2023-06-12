package com.liferay.osb.faro.web.internal.controller.main;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;

import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;

public class OAuth2ControllerTest {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void myTest() throws Exception {
		_oAuth2Controller.newToken(1L, null, _mockHttpServletRequest());
	}

	private HttpServletRequest _mockHttpServletRequest() throws Exception {
		PermissionChecker permissionChecker = Mockito.mock(
			PermissionChecker.class);

		// If I instantiate _oAuth2Controller myself the execution arrives here,
		// but is doesn't create the user. Follow .addUser method until you
		// arrive at CompanyLocalServiceUtil.java#getCompanyByWebId:467.
		// The getService() method there gives me null
		User user = UserTestUtil.addUser();

		Mockito.when(permissionChecker.getUser()).thenReturn(user);

		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		ThemeDisplay themeDisplay = new ThemeDisplay();

		HttpServletRequest httpServletRequest = Mockito.mock(
			HttpServletRequest.class);

		Mockito.when(
			httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY)
		).thenReturn(
			themeDisplay
		);

		return httpServletRequest;
	}

	// @Reference doesn't work.
	@Reference
	OAuth2Controller _oAuth2Controller;

}
