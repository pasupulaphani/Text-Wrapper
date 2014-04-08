package textwrap.textwrap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TextWrapperTest 
    extends TestCase
{
	TextWrapper txtwrp;
	int width = 20;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TextWrapperTest( String testName )
    {
        super( testName );
        txtwrp = new TextWrapper();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TextWrapperTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test_simple_text()
    {
    	String text = "Trignomery creates unique end user monitoring products";
    	String expected_result = (new StringBuilder(text.length())
    			.append("Trignomery creates")
    			.append("\n")
    			.append("unique end user")
    			.append("\n")
    			.append("monitoring products")).toString();
    									
    	String actual_result = txtwrp.wrapText(text, width);
    	assertEquals(expected_result, actual_result );
    }
    
    public void test_text_tail_spacees()
    {
    	String text = "End user   ";
    	String expected_result = "End user";
    	String actual_result = txtwrp.wrapText(text, width);

    	assertEquals(expected_result, actual_result );
    }
    
    public void test_text_more_special_chars()
    {
    	String text = "End user     ,\n";
    	String expected_result = "End user ,";
    	String actual_result = txtwrp.wrapText(text, width);

    	assertEquals(expected_result, actual_result );
    }
    
    public void test_text_special_chars2()
    {
    	String text = "End user ,\n can test this";
    	String expected_result = (new StringBuilder(text.length())
				.append("End user , can")
				.append("\n")
				.append("test this")).toString();
    	String actual_result = txtwrp.wrapText(text, width);

    	assertEquals(expected_result, actual_result );
    }
    
    public void test_start_word_eq_to_width()
    {
    	String text = "test anthropomorphization test";
    	String expected_result = (new StringBuilder(text.length())
				.append("test")
				.append("\n")
				.append("anthropomorphization")
				.append("\n")
				.append("test")).toString();
    	String actual_result = txtwrp.wrapText(text, width);

    	assertEquals(expected_result, actual_result );
    }
    
    public void test_start_word_more_than_width()
    {
    	String text = "anthropomorphizations test";
    	String expected_result = (new StringBuilder(text.length())
				.append("anthropomorphizatio-")
				.append("\n")
				.append("ns test")).toString();
    	String actual_result = txtwrp.wrapText(text, width);

    	assertEquals(expected_result, actual_result );
    }
    
    public void test_word_more_than_width()
    {
    	String text = "test anthropomorphizations ";
    	String expected_result = (new StringBuilder(text.length())
				.append("test anthropomorph-")
				.append("\n")
				.append("izations")).toString();
    	String actual_result = txtwrp.wrapText(text, width);

    	assertEquals(expected_result, actual_result );
    }

    public void test_many_words_more_than_width()
    {
    	String text = "test anthropomorphizations antiferromagnetically";
    	String expected_result = (new StringBuilder(text.length())
				.append("test anthropomorph-")
				.append("\n")
				.append("izations antiferro-")
				.append("\n")
				.append("magnetically")).toString();
    	String actual_result = txtwrp.wrapText(text, width);

    	assertEquals(expected_result, actual_result );
    }
}
