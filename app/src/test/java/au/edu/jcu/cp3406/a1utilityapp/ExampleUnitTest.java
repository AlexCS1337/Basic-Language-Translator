package au.edu.jcu.cp3406.a1utilityapp;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void run_translation_test() {
        String text = "Hello world";
        System.out.println("Given text is " + text);
        String translatedText;
        translatedText = "こんにちは世界！\nkonnichiwa sekai";
        System.out.println("translated text is" + translatedText);
    }

    @Test
    public void testUILanguageChange() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(new Locale("es", "ES"));
        //testUILanguageChange();
        Locale.setDefault(new Locale("ja", "JA"));
        //testUILanguageChange();
        Locale.setDefault(defaultLocale);
    }

}