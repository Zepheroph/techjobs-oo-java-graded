package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import org.launchcode.techjobs.oo.Job;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

        private Job job1, job2, job3, job4, job5;

        @Before
        public void createTestJobs(){
                job1 = new Job();
                job2 = new Job();
                job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
                job4 = new Job("QA Tester", new Employer("Sony"), new Location("Seattle"), new PositionType("Quality control"), new CoreCompetency("Detail-Oriented"));
                job5 = new Job("Software Developer", new Employer("Nintendo"), new Location("Japan"), new PositionType("Software Engineering"), new CoreCompetency("Patience"));
        }
//write tests. ensure they run. upload and submit
        @Test
        public void testSettingJobId(){
                assertNotEquals(job1.getId(),job2.getId());
        }

        @Test
        public void testJobConstructorSetsAllFields(){
                assertTrue(job3.getName() instanceof String);
                assertTrue(job3.getEmployer() instanceof Employer);
                assertTrue(job3.getLocation() instanceof Location);
                assertTrue(job3.getPositionType() instanceof PositionType);
                assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
                assertEquals(job3.getName(), "Product tester");
                assertEquals(job3.getEmployer().getValue(), "ACME");
                assertEquals(job3.getLocation().getValue(), "Desert");
                assertEquals(job3.getPositionType().getValue(), "Quality control");
                assertEquals(job3.getCoreCompetency().getValue(), "Persistence");

        }


        @Test
        public void testJobsForEquality(){
                Job job3a = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
                assertFalse(job3.equals(job3a));



//                assertTrue(job4.getEmployer() instanceof Employer);
//                assertTrue(job4.getLocation() instanceof Location);
//                assertTrue(job4.getPositionType() instanceof PositionType);
//                assertTrue(job4.getCoreCompetency() instanceof CoreCompetency);
        }

        @Test
        public void testToStringStartsAndEndsWithNewLine(){
                assertEquals('\n',job5.toString().charAt(0));
                assertEquals('\n',job5.toString().charAt(job5.toString().length()-1));
        }

        @Test
        public void testToStringContainsCorrectLabelsAndData(){
             String   output = String.format(
                "\nID: %d\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n", job3.getId(),job3.getName(),job3.getEmployer(),job3.getLocation(),job3.getPositionType(),job3.getCoreCompetency());
        assertEquals(output, job3.toString());
        }

        @Test
        public void testToStringHandlesEmptyField(){
                Employer x = new Employer("");
                job4.setEmployer(x);
              //  System.out.print(job4.getEmployer());
                Location y = new Location("");
                job4.setLocation(y);
                String output = String.format(
                        "\nID: %d\n" +
                                "Name: %s\n" +
                                "Employer: Data not available\n"+
                                "Location: Data not available\n" +
                                "Position Type: %s\n"+
                                "Core Competency: %s\n", job4.getId(), job4.getName(), job4.getPositionType(), job4.getCoreCompetency());
                      assertEquals(output,job4.toString());
                        //cant get this test argument  to settle
        }



}
