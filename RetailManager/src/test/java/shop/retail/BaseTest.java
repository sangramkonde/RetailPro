package shop.retail;

import shop.retail.service.ShopLocator;
import shop.retail.service.ShopLocatorImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Sangram
 *
 */
@ContextConfiguration({"/test-context.xml"})
public class BaseTest {

	@Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ShopLocator shopLocator;

}
