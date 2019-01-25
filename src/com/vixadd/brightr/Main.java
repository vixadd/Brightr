////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
//                                                                            //
// Copyright 2018 David Kroell                                                //
//                                                                            //
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            //
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            //
// OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   //
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS        //
// BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN         //
// ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN          //
// CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
package com.vixadd.brightr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The Main application that gets run to launch
 * the Brightr application.
 * 
 * @author kroelld
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Calculatorview.fxml"));
		
	}
	
	public static void main(String args[]) {
		launch();
	}
	
}
