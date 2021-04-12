package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import seedu.duke.ui.MainUi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

class DukeTest {

    @Test
    public void dummyTest() {
        assertTrue(true);
    }

    @Test
    public void testAdd2ResourcesTo2DifferentProjects() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/Project 1 url/https://www.youtube.com d/YouTube\n"
                + "add p/Project 2 url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project\n"
                + "add p/Project 1 url/https://www.google.com\n"
                + "add p/Project 2 url/https://www.yahoo.com\n"
                + "list-all\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"Project 1\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added into the new project \"Project 2\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"Project 1\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"Project 2\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: Project 1\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://www.youtube.com (Description: YouTube)\n"
                + "2): "
                + "[" + LocalDate.now() + "] "
                + "https://www.google.com\n"
                + "--------------------------------------------------------\n"
                + "Project 2: Project 2\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project)\n"
                + "2): "
                + "[" + LocalDate.now() + "] "
                + "https://www.yahoo.com\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testAdd3DifferentResourceInAProject() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://www.google.com\n"
                + "add p/CS2113 Group Project url/https://www.youtube.com d/YouTube\n"
                + "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project\n"
                + "list-all\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://www.google.com\n"
                + "2): "
                + "[" + LocalDate.now() + "] "
                + "https://www.youtube.com (Description: YouTube)\n"
                + "3): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testAddResourceWithExistingUrl() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project\n"
                + "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "list-all\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "A resource with The same URL has already existed in its resource list. "
                + "If you want to edit the resource, please use \"edit\" command.\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testStrangeSpacing() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "     add      p/        CS2113 Group Project      "
                + "     url/    https://ay2021s2-cs2113-w10-3.github.io/tp/      d/   Team Project  \n"
                + "list-all\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testAddEmptyProjectName() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/ url/https://www.google.com\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "Error: Resource failed to be added. (Reason: Argument cannot be empty.)\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testAddEmptyUrl() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/Project 1 url/ d/YouTube\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "Error: Resource failed to be added. (Reason: Argument cannot be empty.)\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testAddInvalidUrl() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/url/ url/p/ d/testing c/true\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "Error: Resource failed to be added. (Reason: URL provided is not a valid URL.)\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testParameterOrderDetection() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/Testing d/Testing url/https://www.youtube.com\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "Error: Resource failed to be added. (Reason: Mandatory parameters are not provided or "
                + "given provided in invalid order.)\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testCompulsoryParameterMissing() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/Testing d/Testing \n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "Error: Resource failed to be added. (Reason: Mandatory parameters are not provided or "
                + "given provided in invalid order.)\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(newOutputStream.toString(), targetString);

        System.setOut(System.out);
    }

    @Test
    public void testDeleteNotFoundResource() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "add p/CS2113 Group Project url/https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html d/tp Website\n"
                + "list-all\n"
                + "delete p/CS2113 Group Project i/4\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project for CS2113)\n"
                + "2): "
                + "[" + LocalDate.now() + "] "
                + "https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html (Description: tp Website)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Resource is not found. Please enter a valid index. \n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testDeleteNotFoundProject() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "add p/CS2113 Group Project url/https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html d/tp Website\n"
                + "list-all\n"
                + "delete p/CS2113 Individual Project i/4\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project for CS2113)\n"
                + "2): "
                + "[" + LocalDate.now() + "] "
                + "https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html (Description: tp Website)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Project is not found ... \n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    /**
     * Positive case for delete feature.
     * Delete a resource for a specified project.
     */
    @Test
    public void testDeleteAResourceFromProject() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "add p/CS2113 Group Project url/https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html d/tp Website\n"
                + "list-all\n"
                + "delete p/CS2113 Group Project i/2\n"
                + "list-all\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project for CS2113)\n"
                + "2): "
                + "[" + LocalDate.now() + "] "
                + "https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html (Description: tp Website)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is deleted from the project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project for CS2113)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    /**
     * Positive case for delete feature.
     * Delete entire project.
     */
    @Test
    public void testDeleteEntireProject() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "add p/CS2113 Group Project url/https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html d/tp Website\n"
                + "list-all\n"
                + "delete p/CS2113 Group Project\n"
                + "list-all\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "Resource(s):\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://ay2021s2-cs2113-w10-3.github.io/tp/ (Description: Team Project for CS2113)\n"
                + "2): "
                + "[" + LocalDate.now() + "] "
                + "https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html (Description: tp Website)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "All the resources in CS2113 Group Project has been deleted.\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and it's resource(s)!\n"
                + "--------------------------------------------------------" + "\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testEditNotFoundResource() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "edit p/CS2113 Group Project i/3 url/https://nus-cs2113-ay2021s2.github.io/dashboards/contents/tp-progress.html\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Resource is not found. Please enter a valid index. " + "\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";
        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testEditNotFoundProject() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "edit p/CS2113 Individual Project i/1 url/https://nus-cs2113-ay2021s2.github.io/dashboards/contents/tp-progress.html\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Project is not found ... " + "\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";
        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    /**
     * Positive Test Case for edit feature.
     */
    @Test
    public void testEditResource() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "edit p/CS2113 Group Project i/1 url/https://nus-cs2113-ay2021s2.github.io/dashboards/contents/tp-progress.html\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is successfully edited to : " + "\n"
                + "    [" + LocalDate.now() +  "] https://nus-cs2113-ay2021s2.github.io/dashboards/contents/tp-progress.html (Description: Team Project for CS2113)\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";
        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testListAllCommands() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String helpExpectedOutput = "-----------------------------------------"
                + "-------------------------------\n"
                + "Here are the available commands:\n"
                + "add: Adds a resource to a project.\n"
                + "\tFormat: add p/PROJECT_NAME url/URL_LINK [d/LINK_DESCRIPTION c/true]\n"
                + "delete: Deletes a resource from the resource list for a specified project.\n"
                + "\tFormat: delete p/PROJECT_NAME [i/INDEX]\n"
                + "edit: Edits a resource from the resource list for a specified project.\n"
                + "\tFormat: edit p/PROJECT_NAME i/INDEX url/URL_LINK [d/LINK_DESCRIPTION]\n"
                + "list: View the resource list for a specified project.\n"
                + "\tFormat: list p/PROJECT_NAME\n"
                + "list-all: Shows the resource list for all projects.\n"
                + "find: Find resources in a specified project or all projects related to a keyword.\n"
                + "\tFormat: find k/KEYWORD [p/PROJECT_NAME]\n"
                + "save: Saves the current projects and resources to a data file.\n"
                + "load: Loads the projects and resources from the data file if it exists.\n"
                + "exit: Exits the program.\n"
                + "------------------------------------------------------------------------\n\n";

        MainUi.listAllCommands();
        assertEquals(newOutputStream.toString(), helpExpectedOutput);

        System.setOut(System.out);
    }

    //@author yyixue
    @Test
    public void testFindInAllProjects() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "add p/CS2113 Group Project url/https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html d/tp Website\n"
                + "add p/Data Science Project url/https://www.kaggle.com/fedesoriano/stroke-prediction-dataset d/Kaggle Stroke Prediction Dataset Website\n"
                + "find k/Website\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added into the new project \"Data Science Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "Here is the list of all project(s) and its resource(s) matching the keyword!\n"
                + "--------------------------------------------------------" + "\n"
                + "Project 1: CS2113 Group Project\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html (Description: tp Website)\n"
                + "Project 2: Data Science Project\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://www.kaggle.com/fedesoriano/stroke-prediction-dataset (Description: Kaggle Stroke Prediction Dataset Website)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    //@author yyixue
    @Test
    public void testExit() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    //@author yyixue
    @Test
    public void testFindInProject() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "add p/CS2113 Group Project url/https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html d/tp Website\n"
                + "find k/Website p/CS2113 Group Project\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "--------------------------------------------------------" + "\n"
                + "Project: CS2113 Group Project\n"
                + "1): "
                + "[" + LocalDate.now() + "] "
                + "https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html (Description: tp Website)\n"
                + "--------------------------------------------------------\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

    //@author yyixue
    @Test
    public void testFindInNotFoundProject() {
        ByteArrayOutputStream newOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOutputStream));

        String inputToCmd = "add p/CS2113 Group Project url/https://ay2021s2-cs2113-w10-3.github.io/tp/ d/Team Project for CS2113\n"
                + "add p/CS2113 Group Project url/https://nus-cs2113-ay2021s2.github.io/website/admin/tp-expectations.html d/tp Website\n"
                + "find k/Website p/Data Science Project\n"
                + "exit";

        System.setIn(new ByteArrayInputStream(inputToCmd.getBytes()));

        Duke.main(null);

        String targetString = MainUi.DUKE_STANDARD_HEADING
                + "The resource is added into the new project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "The resource is added to the existing project \"CS2113 Group Project\".\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + "--------------------------------------------------------" + "\n"
                + "Project cannot be found! Please enter a valid project name!" + "\n"
                + "--------------------------------------------------------" + "\n"
                + MainUi.SIGNAL_FOR_USER_TO_INPUT
                + MainUi.EXIT_MESSAGE + "\n";

        assertEquals(targetString, newOutputStream.toString());

        System.setOut(System.out);
    }

}
