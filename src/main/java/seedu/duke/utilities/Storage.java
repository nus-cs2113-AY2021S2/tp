package seedu.duke.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import seedu.duke.email.Archive;
import seedu.duke.email.Deleted;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;
import seedu.duke.email.Junk;
import seedu.duke.email.Sent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Storage {
    private String fileName;
    private String filePath;
    private String pwd;
    private String emailAccount;

    public Storage() {
        this.fileName = null;
        this.filePath = null;
        this.pwd = null;
        this.emailAccount = null;

    }

    /**
     * Checks if the data folder exist. If it does not,
     * it means that the jar file is loaded for the first time,
     * so it will copy the data files from inside jar into the
     * data folder.
     */
    public void init() {
        if (createDirectory()) {
            loadResources();
        }
    }

    private void loadResources() {
        String[] files = {"LoginInfo.txt",
                          "12312@gmail.com.json",
                          "test@gmail.com.json",
                          "test@yahoo.com.json"
        };

        for (String file : files) {
            try {
                InputStream in = getClass().getResourceAsStream(File.separator + "data" + File.separator + file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String outputPath = System.getProperty("user.dir") + File.separator + "data" + File.separator + file;
                FileWriter writer = new FileWriter(outputPath);

                String line = reader.readLine();
                while (line != null) {
                    writer.write(line + System.lineSeparator());
                    line = reader.readLine();
                }
                writer.flush();
            } catch (IOException | NullPointerException e) {
                ;   // If no resource file then start afresh
            }
        }
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public String getPwd() {
        return pwd;
    }

    public ArrayList<Email> load(String fileName, String account, String pwd)
            throws IOException, ParseException, NullPointerException {
        this.fileName = fileName;
        this.filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + fileName;
        this.pwd = pwd;
        this.emailAccount = account;

        try {
            JSONObject accountInfo = readJson();
            pwd = getPassword(accountInfo);
            ArrayList<Email> emailList = parse(accountInfo);
            return emailList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Opens and reads JSON file from the hard disk.
     * The content of the file is parsed into JSON object
     * before it is returned.
     *
     * @return The content parsed as JSON object
     * @throws IOException    if failed to create directory 'data'.
     * @throws ParseException if file is corrupted.
     */
    private JSONObject readJson() throws IOException, ParseException {
        createDirectory();
        File file = new File(filePath);
        if (!file.exists()) {
            createJsonFile(file);
        }

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }

    /**
     * Creates the data folder if it does not exist.
     *
     * @return true if folder is created (i.e. folder does not exist), false otherwise.
     */
    private boolean createDirectory() {
        String localDir = System.getProperty("user.dir");
        Path dirPath = Paths.get(localDir, "data");
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectory(dirPath);
                return true;
            } catch (IOException e) {
                System.err.println("Failed to create directory 'data'!" + e.getMessage());
            }
        }
        return false;
    }

    private ArrayList<Email> parse(JSONObject jsonObject) throws NullPointerException {
        ArrayList<Email> allEmails = new ArrayList<>();
        ArrayList<String> emailType = new ArrayList<>();
        for (Object key : jsonObject.keySet()) {
            if (!key.toString().equals("account") && !key.toString().equals("password")) {
                emailType.add(key.toString());
            }
        }
        for (String type : emailType) {
            JSONArray companyList = (JSONArray) jsonObject.get(type);
            Iterator<JSONObject> iterator = companyList.iterator();
            try {
                while (iterator.hasNext()) {
                    Map e = iterator.next();
                    String from = e.get("from").toString();
                    ArrayList<String> to = getArrayList((JSONArray) e.get("to"));
                    String subject = e.get("subject").toString();
                    String time = e.get("time").toString();
                    String content = e.get("content").toString();
                    ArrayList<String> tags = getArrayList((JSONArray) e.get("tags"));
                    boolean isRead = getRead(e.get("read").toString());

                    Email email = null;
                    switch (type) {
                    case "inbox":
                        email = new Inbox(from, to, subject, time, content, isRead);
                        break;
                    case "drafts":
                        email = new Draft(from, to, subject, time, content, isRead);
                        break;
                    case "archive":
                        email = new Archive(from, to, subject, time, content, isRead);
                        break;
                    case "sent":
                        email = new Sent(from, to, subject, time, content, isRead);
                        break;
                    case "deleted":
                        email = new Deleted(from, to, subject, time, content, isRead);
                        break;
                    case "junk":
                        email = new Junk(from, to, subject, time, content, isRead);
                        break;
                    default:
                        continue;
                    }

                    email.setTags(tags);
                    allEmails.add(email);
                }
            } catch (NullPointerException e) {
                throw e;
            }
        }
        return allEmails;
    }

    private ArrayList<String> getArrayList(JSONArray array) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            String element = (String) array.get(i);
            list.add(element);
        }
        return list;
    }

    private boolean getRead(String readString) {
        switch (readString) {
        case "o":
            return true;
        case "x":
            return false;
        default:
            throw new NullPointerException();
        }
    }

    public String getPassword(JSONObject jsonObject) {
        return (String) jsonObject.get("password");
    }

    public void changePwd(String newPassword) {
        pwd = newPassword;
        updateEmails("password", newPassword);
    }

    public void updateAllTypeEmails(ArrayList<Email> emails) {
        JSONArray inboxList = new JSONArray();
        JSONArray deletedList = new JSONArray();
        JSONArray junkList = new JSONArray();
        JSONArray archiveList = new JSONArray();
        JSONArray sentList = new JSONArray();
        JSONArray draftList = new JSONArray();

        for (Email email : emails) {
            if (email instanceof Inbox) {
                inboxList.add(createJsonObj(email));
            }
            if (email instanceof Deleted) {
                deletedList.add(createJsonObj(email));
            }
            if (email instanceof Junk) {
                junkList.add(createJsonObj(email));
            }
            if (email instanceof Archive) {
                archiveList.add(createJsonObj(email));
            }
            if (email instanceof Sent) {
                sentList.add(createJsonObj(email));
            }
            if (email instanceof Draft) {
                draftList.add(createJsonObj(email));
            }
        }
        updateEmails("inbox", inboxList);
        updateEmails("deleted", deletedList);
        updateEmails("junk", junkList);
        updateEmails("archive", archiveList);
        updateEmails("sent", sentList);
        updateEmails("drafts", draftList);
    }

    private JSONObject createJsonObj(Email email) {
        JSONObject emailObj = new JSONObject();
        JSONArray toList = new JSONArray();
        JSONArray tagList = new JSONArray();

        emailObj.put("subject", email.getSubject());
        emailObj.put("from", email.getFrom());
        for (String to : email.getTo()) {
            toList.add(to);
        }
        emailObj.put("to", toList);
        emailObj.put("time", email.getTime());
        emailObj.put("read", email.isRead() ? "o" : "x");
        for (String tag : email.getTags()) {
            tagList.add(tag);
        }
        emailObj.put("tags", tagList);
        emailObj.put("content", email.getContent());
        return emailObj;
    }

    private <T> void updateEmails(String key, T newValue) {

        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            jsonObject.put(key, newValue);
            FileWriter file = new FileWriter(filePath);
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private void createJsonFile(File file) {
        try {
            file.createNewFile();
            JSONObject js = new JSONObject();
            JSONArray inboxList = new JSONArray();
            JSONArray deletedList = new JSONArray();
            JSONArray junkList = new JSONArray();
            JSONArray archiveList = new JSONArray();
            JSONArray sentList = new JSONArray();
            JSONArray draftList = new JSONArray();
            js.put("account", emailAccount);
            js.put("password", pwd);
            js.put("inbox", inboxList);
            js.put("deleted", deletedList);
            js.put("junk", junkList);
            js.put("archive", archiveList);
            js.put("sent", sentList);
            js.put("drafts", draftList);

            FileWriter fw = new FileWriter(filePath);
            fw.write(js.toJSONString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
