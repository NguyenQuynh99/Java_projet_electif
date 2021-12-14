/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author hnguyen01
 */
/**
 * thrown when an invalid sequence like \g is encountered while parsing a symbol
 */
public class StringFormatException extends Exception { static final long serialVersionUID =30101L;

  public StringFormatException() {
    super();
  }

  public StringFormatException(String mess) {
    super(mess);
  }

  public StringFormatException(String mess,Throwable cause) {
    super(mess,cause);
  }

  public StringFormatException(Throwable cause) {
    super(cause);
  }

}