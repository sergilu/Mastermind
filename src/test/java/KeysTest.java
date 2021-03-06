import core.Code;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import core.KeyPeg;
import core.Keys;
class KeysTest {


  @Test
  public void testGetKeys(){
    KeyPeg[][] keys= {
        {KeyPeg.CorrectPosition,KeyPeg.DoesNotExistColor},
        {KeyPeg.CorrectPosition},
        {KeyPeg.CorrectPosition,KeyPeg.DoesNotExistColor,KeyPeg.ExistColor}};
    for (KeyPeg[] key : keys){
      Keys key1= new Keys(key);
      Assertions.assertArrayEquals(key,key1.getKeys());
    }

  }
  /*Test de Caixa Negra:
   * Particions equivalents(valides)*/
  @Test
  void testgetLength() {
    Keys keys =new Keys(new KeyPeg[]{KeyPeg.ExistColor});
    Keys keys2 =new Keys(new KeyPeg[]{KeyPeg.ExistColor,KeyPeg.DoesNotExistColor});
    Keys keys3 =new Keys(new KeyPeg[]{KeyPeg.ExistColor,KeyPeg.CorrectPosition,KeyPeg.DoesNotExistColor});
    Assertions.assertEquals(1,keys.getLength());
    Assertions.assertEquals(2,keys2.getLength());
    Assertions.assertEquals(3,keys3.getLength());
  }
  /*Test de Caixa Negra:
   * Particions equivalents(invalides)*/
  @Test
  public void it_should_throw_RuntimeException_when_key_length_is_0(){
    Assertions.assertThrows(RuntimeException.class, ()-> new Keys(new KeyPeg[]{}));
  }
  /*Test de Caixa Negra:
   * Particions equivalents(invalides)*/
  @Test
  public void it_should_throw_RuntimeException_when_key_length_is_null(){
    Assertions.assertThrows(RuntimeException.class, ()-> new Keys(null));
  }

  /*Test de Caixa Negra:
   *Particions equivalents(valides)*/
  @Test
  void testEqualKeys() {
    Keys keys1 = new Keys(new KeyPeg[]{KeyPeg.CorrectPosition,KeyPeg.DoesNotExistColor});
    Assertions.assertNotEquals(null,keys1);
    Assertions.assertEquals(keys1,keys1);
    Keys keys1b = keys1;
    Assertions.assertEquals(keys1,keys1b);

    Keys keys2 = new Keys(new KeyPeg[]{KeyPeg.CorrectPosition,KeyPeg.DoesNotExistColor});
    Assertions.assertEquals(keys1, keys2);

    Keys keys3 = new Keys(new KeyPeg[]{KeyPeg.ExistColor,KeyPeg.DoesNotExistColor});
    Assertions.assertNotEquals(keys1, keys3); 
  }

  


}