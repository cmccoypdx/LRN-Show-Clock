/***************************************************************************
*   LRN Show Clock. Flashes a countdown on screen to warn user of          *
*   beginning and end of commercial break, for radio programs. Runs        *
*   during user configured showtimes, with breaks based on Liberty         *
*   Radio Network schedule.                                                *
*                                                                          *
*   Copyright (C) 2014  Colin Michael McCoy                                *
*                                                                          *
*   This program is free software: you can redistribute it and/or modify   *
*   it under the terms of the GNU General Public License as published by   *
*   the Free Software Foundation, either version 3 of the License, or      *   
*   (at your option) any later version.                                    *
*                                                                          *
*   This program is distributed in the hope that it will be useful,        *
*   but WITHOUT ANY WARRANTY; without even the implied warranty of         *
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the          *
*   GNU General Public License for more details.                           *
*                                                                          *
*   You should have received a copy of the GNU General Public License      *
*   along with this program.  If not, see <http://www.gnu.org/licenses/>.  *
*                                                                          *
*   To contact the author, write to mick4747@gmail.com.                    *
*                                                                          *
***************************************************************************/

package SettingsGui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import org.quartz.SchedulerException;


public class ShowtimeSettings extends javax.swing.JFrame {
    //Declared values are defaults for if no previous_selections.txt file exists
    private int startHour = 12;
    private int endHour = 12;
    private int startMinute = 0;
    private int endMinute = 0;
    private boolean sameAT = true;
    private String startValue1 = "PM";
    private String startValue2 = "AM";
    private String endValue1 = "PM";
    private String endValue2 = "AM";
    private boolean[] daysChecked = new boolean[7];

    /**
     * Creates new form ShowtimeSettings
     */
    public ShowtimeSettings() {
        //previous_selections.txt stores user values from previous session
        File f = new File("previous_selections.txt");
        if (f.exists()) {
            //Set variable values from previous user selections
            try {
                try (Scanner scan = new Scanner(f)) {
                    startHour = Integer.parseInt(scan.next());
                    endHour = Integer.parseInt(scan.next());
                    startMinute = Integer.parseInt(scan.next());
                    endMinute = Integer.parseInt(scan.next());
                    sameAT = Boolean.valueOf(scan.next());
                    startValue1 = scan.next();
                    startValue2 = scan.next();
                    endValue1 = scan.next();
                    endValue2= scan.next();
                    for(int i = 0; i < daysChecked.length; i++) {
                        daysChecked[i] = Boolean.valueOf(scan.next());
                    }
                }
            } catch(IOException ex) {
                    Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource(
                "ShowClockWindowLogo.png")).getImage());
        
         
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sameAirtimeGroup = new javax.swing.ButtonGroup();
        showtimesPanel = new javax.swing.JPanel();
        showTimeHeader = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        weekdaysHeader = new javax.swing.JLabel();
        sunCheck = new javax.swing.JCheckBox();
        monCheck = new javax.swing.JCheckBox();
        tueCheck = new javax.swing.JCheckBox();
        wedCheck = new javax.swing.JCheckBox();
        thuCheck = new javax.swing.JCheckBox();
        friCheck = new javax.swing.JCheckBox();
        satCheck = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        timesHeader = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        endTimeLabel = new javax.swing.JLabel();
        startColon = new javax.swing.JLabel();
        startMinuteSpinner = new javax.swing.JSpinner();
        startAmPmSpinner = new javax.swing.JSpinner();
        startHourSpinner = new javax.swing.JSpinner();
        endHourSpinner = new javax.swing.JSpinner();
        endColon = new javax.swing.JLabel();
        endMinuteSpinner = new javax.swing.JSpinner();
        endAmPmSpinner = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JSeparator();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        sameAirtimeLabel = new javax.swing.JLabel();
        sameAirtimeYes = new javax.swing.JRadioButton();
        sameAirtimeNo = new javax.swing.JRadioButton();
        dailyAirtimesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings\n");
        setResizable(false);

        showtimesPanel.setBackground(new java.awt.Color(255, 255, 255));

        showTimeHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        showTimeHeader.setText("Set Show Times");

        weekdaysHeader.setText("Check each day of the week that the show airs");

        sunCheck.setBackground(new java.awt.Color(255, 255, 255));
        sunCheck.setText("Sun");
        sunCheck.setSelected(daysChecked[0]);
        sunCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunCheckActionPerformed(evt);
            }
        });

        monCheck.setBackground(new java.awt.Color(255, 255, 255));
        monCheck.setText("Mon");
        monCheck.setSelected(daysChecked[1]);
        monCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monCheckActionPerformed(evt);
            }
        });

        tueCheck.setBackground(new java.awt.Color(255, 255, 255));
        tueCheck.setText("Tue");
        tueCheck.setSelected(daysChecked[2]);
        tueCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tueCheckActionPerformed(evt);
            }
        });

        wedCheck.setBackground(new java.awt.Color(255, 255, 255));
        wedCheck.setText("Wed");
        wedCheck.setSelected(daysChecked[3]);
        wedCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wedCheckActionPerformed(evt);
            }
        });

        thuCheck.setBackground(new java.awt.Color(255, 255, 255));
        thuCheck.setText("Thu");
        thuCheck.setSelected(daysChecked[4]);
        thuCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thuCheckActionPerformed(evt);
            }
        });

        friCheck.setBackground(new java.awt.Color(255, 255, 255));
        friCheck.setText("Fri");
        friCheck.setSelected(daysChecked[5]);
        friCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friCheckActionPerformed(evt);
            }
        });

        satCheck.setBackground(new java.awt.Color(255, 255, 255));
        satCheck.setText("Sat");
        satCheck.setSelected(daysChecked[6]);
        satCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satCheckActionPerformed(evt);
            }
        });

        timesHeader.setText("Select the start and end times for the show");
        timesHeader.setEnabled(sameAT);

        startTimeLabel.setText("Start");
        startTimeLabel.setEnabled(sameAT);

        endTimeLabel.setText("End");
        endTimeLabel.setEnabled(sameAT);

        startColon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startColon.setText(":");

        startMinuteSpinner.setModel(new CyclingSpinnerNumberModel(startMinute,0,59,1));
        startMinuteSpinner.setEditor(new JSpinner.NumberEditor(startMinuteSpinner, "00"));
        startMinuteSpinner.setEnabled(sameAT);
        startMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startMinuteSpinnerStateChanged(evt);
            }
        });

        startAmPmSpinner.setModel(new CyclingSpinnerListModel(new String[] {startValue1, startValue2}));
        startAmPmSpinner.setEnabled(sameAT);
        startAmPmSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startAmPmSpinnerStateChanged(evt);
            }
        });

        startHourSpinner.setModel(new CyclingSpinnerNumberModel(startHour,1,12,1));
        startHourSpinner.setEnabled(sameAT);
        startHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startHourSpinnerStateChanged(evt);
            }
        });

        endHourSpinner.setModel(new CyclingSpinnerNumberModel(endHour,1,12,1));
        endHourSpinner.setEnabled(sameAT);
        endHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                endHourSpinnerStateChanged(evt);
            }
        });

        endColon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        endColon.setText(":");

        endMinuteSpinner.setModel(new CyclingSpinnerNumberModel(endMinute,0,59,1));
        endMinuteSpinner.setEditor(new JSpinner.NumberEditor(endMinuteSpinner, "00"));
        endMinuteSpinner.setEnabled(sameAT);
        endMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                endMinuteSpinnerStateChanged(evt);
            }
        });

        endAmPmSpinner.setModel(new CyclingSpinnerListModel(new String[] {endValue1, endValue2}));
        endAmPmSpinner.setEnabled(sameAT);
        endAmPmSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                endAmPmSpinnerStateChanged(evt);
            }
        });

        applyButton.setText("Apply");
        applyButton.setEnabled(false);
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        sameAirtimeLabel.setText("Does the show have the same airtime every day that it airs?");

        sameAirtimeYes.setBackground(new java.awt.Color(255, 255, 255));
        sameAirtimeYes.setText("Yes");
        sameAirtimeGroup.add(sameAirtimeYes);
        sameAirtimeYes.setSelected(sameAT);
        sameAirtimeYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sameAirtimeYesActionPerformed(evt);
            }
        });

        sameAirtimeNo.setBackground(new java.awt.Color(255, 255, 255));
        sameAirtimeNo.setText("No");
        sameAirtimeGroup.add(sameAirtimeNo);
        sameAirtimeNo.setSelected(!sameAT);
        sameAirtimeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sameAirtimeNoActionPerformed(evt);
            }
        });

        dailyAirtimesButton.setText("Set Daily Airtimes");
        dailyAirtimesButton.setEnabled(!sameAT);
        dailyAirtimesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyAirtimesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showtimesPanelLayout = new javax.swing.GroupLayout(showtimesPanel);
        showtimesPanel.setLayout(showtimesPanelLayout);
        showtimesPanelLayout.setHorizontalGroup(
            showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showtimesPanelLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton)
                .addGap(20, 20, 20))
            .addGroup(showtimesPanelLayout.createSequentialGroup()
                .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showtimesPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startTimeLabel)
                            .addComponent(endTimeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startHourSpinner)
                            .addComponent(endHourSpinner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startColon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endColon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endMinuteSpinner)
                            .addComponent(startMinuteSpinner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endAmPmSpinner)
                            .addComponent(startAmPmSpinner)))
                    .addGroup(showtimesPanelLayout.createSequentialGroup()
                        .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showtimesPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(timesHeader))
                            .addGroup(showtimesPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(weekdaysHeader)
                                    .addComponent(showTimeHeader)
                                    .addGroup(showtimesPanelLayout.createSequentialGroup()
                                        .addComponent(sunCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(monCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tueCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wedCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(thuCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(friCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(satCheck))))
                            .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, showtimesPanelLayout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(sameAirtimeLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, showtimesPanelLayout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sameAirtimeNo)
                                        .addComponent(sameAirtimeYes))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dailyAirtimesButton))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        showtimesPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {applyButton, cancelButton, okButton});

        showtimesPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {endAmPmSpinner, endHourSpinner, endMinuteSpinner, startAmPmSpinner, startHourSpinner, startMinuteSpinner});

        showtimesPanelLayout.setVerticalGroup(
            showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showtimesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showTimeHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekdaysHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sunCheck)
                    .addComponent(monCheck)
                    .addComponent(tueCheck)
                    .addComponent(wedCheck)
                    .addComponent(thuCheck)
                    .addComponent(friCheck)
                    .addComponent(satCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sameAirtimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sameAirtimeYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dailyAirtimesButton)
                    .addComponent(sameAirtimeNo))
                .addGap(27, 27, 27)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timesHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startTimeLabel)
                    .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startColon)
                        .addComponent(startMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startAmPmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endTimeLabel)
                    .addComponent(endHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endColon)
                    .addComponent(endMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endAmPmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(showtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton)
                    .addComponent(applyButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showtimesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showtimesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-411)/2, (screenSize.height-432)/2, 411, 432);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void sunCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunCheckActionPerformed
        applyButton.setEnabled(true);
    }//GEN-LAST:event_sunCheckActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        applyButton.setEnabled(false);
        //find out what days the user has checked
        daysChecked[0] = sunCheck.isSelected();
        daysChecked[1] = monCheck.isSelected();
        daysChecked[2] = tueCheck.isSelected();
        daysChecked[3] = wedCheck.isSelected();
        daysChecked[4] = thuCheck.isSelected();
        daysChecked[5] = friCheck.isSelected();
        daysChecked[6] = satCheck.isSelected();
           
        try {
            
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("excludedDays.txt")))) {
                  for(boolean day : daysChecked) {
                      out.println(String.valueOf(!day));
                  }
            }
            } catch (IOException ex) {
                    Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        if(sameAirtimeYes.isSelected()){
                sameAT = true;
                //get start and end times
                startHour = (Integer) startHourSpinner.getValue();
                startMinute = (Integer) startMinuteSpinner.getValue();
                endHour = (Integer) endHourSpinner.getValue();
                endMinute = (Integer) endMinuteSpinner.getValue();
                startValue1 = (String) startAmPmSpinner.getValue();
                if(startValue1.equals("AM")) { startValue2 = "PM"; }
                endValue1 = (String) endAmPmSpinner.getValue();
                if(endValue1.equals("AM")) { endValue2 = "PM"; }
                //convert to 24-hour time
                if (startValue1.equals("PM") && startHour != 12) {
                    startHour += 12;
                }
                if (startValue1.equals("AM") && startHour == 12) {
                    startHour = 0;
                }
                if (endValue1.equals("PM") && endHour != 12) {
                    endHour += 12;
                }
                if (endValue1.equals("AM") && endHour == 12) {
                    endHour = 0;
                }
                int mins = 0;     //show's runtime in minutes
                if(endHour >= startHour) {
                    mins = ((endHour - startHour) * 60 + endMinute) - startMinute;
                }
                else if(endHour == 0){
                    mins = (24 - startHour) * 60 + (endMinute - startMinute);
                }
                else {  //show runs past midnight
                    mins = endHour * 60 + endMinute + (24- startHour) * 60 - startMinute;
                }
                try {
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("showtimes.txt")))) {
                        out.println(mins);
                        out.println("* " + startMinute + " " + startHour + " ? * *");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
                }
                //convert back to 12-hour time
                if(startHour > 12) { startHour -= 12; }
                if(endHour > 12) { endHour -= 12; }
                if(startHour == 0) { startHour = 12; }
                if(endHour == 0) { endHour = 12; }
                
        }
        else { sameAT = false; }
        try {
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("previous_selections.txt")))) {
                        out.println(startHour);
                        out.println(endHour);
                        out.println(startMinute);
                        out.println(endMinute);
                        out.println(String.valueOf(sameAT));
                        out.println(startValue1);
                        out.println(startValue2);
                        out.println(endValue1);
                        out.println(endValue2);
                        for(boolean day : daysChecked) {
                            out.println(day);
                        }
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
                }
        try {
            LRNScheduler.SchedulerUtils.startScheduler();
        } catch (SchedulerException ex) {
            Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void monCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monCheckActionPerformed
        applyButton.setEnabled(true);
    }//GEN-LAST:event_monCheckActionPerformed

    private void tueCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tueCheckActionPerformed
        applyButton.setEnabled(true);
    }//GEN-LAST:event_tueCheckActionPerformed

    private void wedCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wedCheckActionPerformed
        applyButton.setEnabled(true);
    }//GEN-LAST:event_wedCheckActionPerformed

    private void thuCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thuCheckActionPerformed
        applyButton.setEnabled(true);
    }//GEN-LAST:event_thuCheckActionPerformed

    private void friCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friCheckActionPerformed
        applyButton.setEnabled(true);
    }//GEN-LAST:event_friCheckActionPerformed

    private void satCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satCheckActionPerformed
        applyButton.setEnabled(true);
    }//GEN-LAST:event_satCheckActionPerformed

    private void startHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_startHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_startHourSpinnerStateChanged

    private void endHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_endHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_endHourSpinnerStateChanged

    private void startMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_startMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_startMinuteSpinnerStateChanged

    private void endMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_endMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_endMinuteSpinnerStateChanged

    private void startAmPmSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_startAmPmSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_startAmPmSpinnerStateChanged

    private void endAmPmSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_endAmPmSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_endAmPmSpinnerStateChanged

    private void sameAirtimeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sameAirtimeNoActionPerformed
        applyButton.setEnabled(true);
        endAmPmSpinner.setEnabled(false);
        endHourSpinner.setEnabled(false);
        endMinuteSpinner.setEnabled(false);
        startAmPmSpinner.setEnabled(false);
        startMinuteSpinner.setEnabled(false);
        startHourSpinner.setEnabled(false);
        endColon.setEnabled(false);
        endTimeLabel.setEnabled(false);
        startColon.setEnabled(false);
        startTimeLabel.setEnabled(false);
        timesHeader.setEnabled(false);
        dailyAirtimesButton.setEnabled(true);
    }//GEN-LAST:event_sameAirtimeNoActionPerformed

    private void sameAirtimeYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sameAirtimeYesActionPerformed
        applyButton.setEnabled(true);
        endAmPmSpinner.setEnabled(true);
        endHourSpinner.setEnabled(true);
        endMinuteSpinner.setEnabled(true);
        startAmPmSpinner.setEnabled(true);
        startMinuteSpinner.setEnabled(true);
        startHourSpinner.setEnabled(true);
        endColon.setEnabled(true);
        endTimeLabel.setEnabled(true);
        startColon.setEnabled(true);
        startTimeLabel.setEnabled(true);
        timesHeader.setEnabled(true);
        dailyAirtimesButton.setEnabled(false);
    }//GEN-LAST:event_sameAirtimeYesActionPerformed

    private void dailyAirtimesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyAirtimesButtonActionPerformed
       java.awt.EventQueue.invokeLater(new Runnable() {
           @Override
            public void run() {
                DailyAirtimeSettings dialog = new DailyAirtimeSettings(new javax.swing.JFrame(), true, 
                        sunCheck.isSelected(), monCheck.isSelected(),tueCheck.isSelected(),wedCheck.isSelected(),
                        thuCheck.isSelected(),friCheck.isSelected(),satCheck.isSelected());
                dialog.setVisible(true);
            }
       });
       applyButton.setEnabled(true);
    }//GEN-LAST:event_dailyAirtimesButtonActionPerformed
    
    public static void showtimeSettings() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
  //          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //            if ("Nimbus".equals(info.getName())) {
      //              javax.swing.UIManager.setLookAndFeel(info.getClassName());
        //            break;
          //      }
          //  }
       // } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
         //   java.util.logging.Logger.getLogger(ShowtimeSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      //  }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShowtimeSettings().setVisible(true);
            

            }
        });
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton dailyAirtimesButton;
    private javax.swing.JSpinner endAmPmSpinner;
    private javax.swing.JLabel endColon;
    private javax.swing.JSpinner endHourSpinner;
    private javax.swing.JSpinner endMinuteSpinner;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JCheckBox friCheck;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JCheckBox monCheck;
    private javax.swing.JButton okButton;
    private javax.swing.ButtonGroup sameAirtimeGroup;
    private javax.swing.JLabel sameAirtimeLabel;
    private javax.swing.JRadioButton sameAirtimeNo;
    private javax.swing.JRadioButton sameAirtimeYes;
    private javax.swing.JCheckBox satCheck;
    private javax.swing.JLabel showTimeHeader;
    private javax.swing.JPanel showtimesPanel;
    private javax.swing.JSpinner startAmPmSpinner;
    private javax.swing.JLabel startColon;
    private javax.swing.JSpinner startHourSpinner;
    private javax.swing.JSpinner startMinuteSpinner;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JCheckBox sunCheck;
    private javax.swing.JCheckBox thuCheck;
    private javax.swing.JLabel timesHeader;
    private javax.swing.JCheckBox tueCheck;
    private javax.swing.JCheckBox wedCheck;
    private javax.swing.JLabel weekdaysHeader;
    // End of variables declaration//GEN-END:variables
}
