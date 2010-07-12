/*
 * Copyright (c) 2010, Lauren Darcey and Shane Conder
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are 
 * permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this list of 
 *   conditions and the following disclaimer.
 *   
 * * Redistributions in binary form must reproduce the above copyright notice, this list 
 *   of conditions and the following disclaimer in the documentation and/or other 
 *   materials provided with the distribution.
 *   
 * * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used
 *   to endorse or promote products derived from this software without specific prior 
 *   written permission.
 *   
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR 
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF 
 * THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * <ORGANIZATION> = Mamlambo
 */
package com.mamlambo.tutorial.formatstrings;

import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FormatStringActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
public void formatStrings(View button) {
		Random generator = new Random();

		final EditText nameField = (EditText) findViewById(R.id.EditTextName);
		String name = nameField.getText().toString();
			
		final Spinner careerSpinner = (Spinner) findViewById(R.id.SpinnerCareer);
		String career = careerSpinner.getSelectedItem().toString();
		
		if(career.equalsIgnoreCase(getResources().getString(R.string.developer))==true)
		{
			career = career + getResources().getString(R.string.heckle);
		}

		final Spinner diseaseSpinner = (Spinner) findViewById(R.id.SpinnerDisease);
		String disease = diseaseSpinner.getSelectedItem().toString();
		
		String strMeatFormat = getResources().getString(R.string.meatShootingMessage);
		int numPoundsMeat = generator.nextInt( 2000 );
		String strMeatMsg = String.format(strMeatFormat, numPoundsMeat);

		String strCareerFormat = getResources().getString(R.string.careerMessage);
		String strCareerMsg = String.format(strCareerFormat, career);
		
		String strDisease1Format = getResources().getString(R.string.diseaseMessage);
		String strDisease1Msg = String.format(strDisease1Format, name, disease);
		
		String strDisease2Format = getResources().getString(R.string.diseaseMessage2);
		String strDisease2Msg = String.format(strDisease2Format, name, disease);
		
		String strKinSurvivalFormat = getResources().getString(R.string.kinSurvivalMessage);
		int numFamily = 5;
		int numSurvived = generator.nextInt( numFamily ) + 1;
		String strKinSurvivalMsg = String.format(strKinSurvivalFormat, numSurvived, numFamily);		
				
		final TextView shootTextView = (TextView) findViewById(R.id.TextView_Shoot);
		shootTextView.setText(strMeatMsg);
		
		final TextView careerTextView = (TextView) findViewById(R.id.TextView_Career);
		careerTextView.setText(strCareerMsg);
		
		final TextView disease1TextView = (TextView) findViewById(R.id.TextView_Disease1);
		disease1TextView.setText(strDisease1Msg);
		
		final TextView disease2TextView = (TextView) findViewById(R.id.TextView_Disease2);
		disease2TextView.setText(strDisease2Msg);
		
		final TextView survivalTextView = (TextView) findViewById(R.id.TextView_Survival);
		survivalTextView.setText(strKinSurvivalMsg);
		
	}

}