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

import javafx.geometry.Insets;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The Main application that gets run to launch
 * the Brightr application.
 * 
 * @author kroelld
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label label = new Label("Select Brightness Level:");
		Slider slider = new Slider();
		
		// Slider configuration.
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(80);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable,
								Number oldValue,
								Number newValue) {
				try {
					// Run unix based command using the runtime exec method:
					mScriptProcess = Runtime.getRuntime().exec("");
				
					// 
					stdScriptCall = new BufferedReader(
							new InputStreamReader(mScriptProcess.getInputStream())
							);
					
					// Errored scream to debug.
					stdScriptCall = new BufferedReader(
							new InputStreamReader(mScriptProcess.getErrorStream())
							);
					
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		});
		
		// Root configuration.
		slider.setBlockIncrement(10);
		VBox root = new VBox();
		root.setPadding(new Insets(20));
		root.setSpacing(10);
		root.getChildren().addAll(label, slider);
		
		// Add a listener to close the window if you click outside it's borders.
		primaryStage.focusedProperty().addListener((obs, wasFocused,  isNowFocused) -> {
			if(wasFocused) {
				if(wasFocused && !isNowFocused) {
					System.out.println("close the window.");
				}
			}
		});
		
		// Display the screen brightness mode for your screen.
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(new Scene(root, 300, 100));
		primaryStage.show();
		
	}
	
	public static void main(String args[]) {
		launch(); // Launch the application
	}
	
	public static BufferedReader getScriptCall() {
		return stdScriptCall;
	}
	
	private static BufferedReader stdScriptCall;
	private static Process mScriptProcess = null;
	
}
