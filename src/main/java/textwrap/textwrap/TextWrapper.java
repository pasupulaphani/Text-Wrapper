package textwrap.textwrap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This class enables a user to feed in a text file with a desired output
 * column width, which is output to the screen wrapped to the specifed output
 * column width.
 */
public class TextWrapper
{

	String TOKEN_SEPERATOR_REGEX = "\\s+";
	
  /**
   * Run this method to run this program.
   */
  public static void main(String[] args)
  {
    /* this program requires 2 parameters to run */
    if (args.length >= 2)
    {
      try
      {
        TextWrapper textWrapper = new TextWrapper();
        String text = textWrapper.readText(new BufferedReader(new FileReader(args[0])));
        int colWidth = Integer.parseInt(args[1]);
        String wrap_output = textWrapper.wrapText(text, colWidth);
        System.out.println("\nWrapped text :\n");
        System.out.println(wrap_output);
      } 
      catch (FileNotFoundException e)
      {
        System.err.println("Could not find file '" + args[0] + "'");
      }
      catch (NumberFormatException e)
      {
        System.err.println("'" + args[1] + "' is not a number");
      }
    }
    else
    {
      System.out.println("This program requires 2 parameters to run: " +
		         "a filename (string) and a column width (integer)");
    }
  }

  /**
   * Reads from the BufferedReader and returns the contents as a String.
   * @param br - the BufferedReader to read from.
   * @return the text as a String.
   */
  public String readText(BufferedReader br)
  {
    StringBuffer sb = new StringBuffer();
    try
    {
      String line;
      while ((line = br.readLine()) != null)
      {
    	  if (sb.length() > 0) {
    		  line = " " + line.trim();
    	  } else {
    		  line = line.trim();
    	  }
        sb.append(line);
      }
      br.close();
    }
    catch (IOException e)
    {
      System.err.println("An IOException occurred: " + e);
    }
    return sb.toString();
  }

  /**
   * Prints the text to the screen, wrapping each line at the 'width'.
   * @param text - the text to wrap and output.
   * @param width - the column width for outputting the text.
   * @return the wrapped text as a String.
   */
  public String wrapText(String text, int width)
  {
//    System.out.println(text);

    List<String> tokens = new ArrayList<String>(Arrays.asList(text.split(TOKEN_SEPERATOR_REGEX)));
    StringBuilder wrap_output = new StringBuilder(text.length());
    int line_length = 0;

    for (int i = 0; i < tokens.size(); i++) {
    	String word = tokens.get(i);

    	// In the event where the word length > 20 we must break it
    	// as there is no way we can fit in our line width
    	if (word.length() > width) {
    		int word_overflow_index = width - line_length - 1;
        	if (line_length != 0) {
        		word = " " + word;
        	}
    		wrap_output.append(word.substring(0, word_overflow_index)
    						+ "-"
    						+ "\n");
    		
    		// insert overflow of the word into the list as a new token
    		tokens.add(i + 1, word.substring(word_overflow_index));
    		line_length = 0;
    		continue;
    	}
    	
    	if (line_length + word.length() > width) {
    		wrap_output.append("\n");
    		line_length = 0;
    	}
    	
    	if (line_length != 0) {
    		word = " " + word;
    	}

		wrap_output.append(word);
    	line_length += word.length() + 1;
    	
    }

	return wrap_output.toString();
  }

}

