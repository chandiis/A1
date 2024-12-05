package Uppgifter.A1;

import java.util.*; //Scanner, Locale
import static java.lang.System.out;

class Temperatures1 
{
    public static void main (String args[])
    {
        out.println("TEMPERATURES\n");

        //input tool
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        //enter the number of weeks and measurements

        out.print("number of weeks: ");
        int nofWeeks = in.nextInt();
        out.print("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();

        //storage space for temperature data
        double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];

        //read the temperatures
            for(int week = 1; week <= nofWeeks; week++)
            {
                out.println("temperatures - week " + week + ":");
                for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
                    t[week][measurement] = in.nextDouble();
            }
                out.println("");

                //show the temperatures
                out.println("the temperatures");
                for (int week = 1; week <= nofWeeks; week++)
                {
                    for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
                        out.print(t[week][measurement] + " ");
                        out.println("");
                }
                out.println("");

                //the least, greatest and average temperatures - weekly
                double[] minT = new double[nofWeeks + 1];
                double[] maxT = new double[nofWeeks + 1];
                double[] sumT = new double[nofWeeks + 1];
                double[] avgT = new double[nofWeeks + 1];
                //add code here

                for (int i = 1; i <= nofWeeks; i++) //outer loop that gives the greatest, least and sum a start value and goes through every week
                 {
                    minT[i] = t[i][1];
                    maxT[i] = t[i][1];
                    sumT[i] = 0;
                
                    for(int j = 1; j <= nofMeasurementsPerWeek; j++) //inner loop that goes through every temperatur every week 
                    {
                       // double currentTemp = t[i][j];

                        if(t[i][j] > maxT[i])
                        {
                            maxT[i] = t[i][j];
                        }
                        
                        if(t[i][j] < minT[i])
                        {
                            minT[i] = t[i][j];
                        }

                        sumT[i] += t[i][j];
                    }

                    avgT[i] = sumT[i] / nofMeasurementsPerWeek;

                 }
               
                //show the least, greatest and average temperatures
                out.println("the least, greatest and average temperatures" + "- weekly");
                for(int week = 1; week <= nofWeeks; week++)
                    out.print(minT[week] + " ");
                out.println("");
                for(int week = 1; week <= nofWeeks; week++)
                    out.print(maxT[week] + " ");
                out.println("");
                for (int week = 1; week <= nofWeeks; week++)
                    out.print(avgT[week] + " ");
                out.println("");
                out.println();

                //the least, greatest and average temperatures - whole period
                double minTemp = minT[1];
                double maxTemp = maxT[1];
                double sumTemp = sumT[1]; //OBS sum is not 0, its the total sum for week 1
                double avgTemp = 0;
                //add code here

                for(int i = 2; i <= nofWeeks; i++) //i = 2 because the start value for sumTemp is sum[1] 
                {
                    sumTemp += sumT[i];

                    if(minT[i] < minTemp)
                    {
                        minTemp = minT[i];
                    }

                    if(maxT[i] > maxTemp)
                    {
                        maxTemp = maxT[i];
                    }
                }

                avgTemp = sumTemp / (nofMeasurementsPerWeek * nofWeeks);

            //show the least, greatest and average temperature for the whole period
                out.println("the least, greatest and average temperature" + " - whole period");
                out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);
                out.println("");

                in.close();
            }
    }
