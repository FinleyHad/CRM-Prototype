The rewritten markdown content that would fit at $SELECTION_PLACEHOLDER$ is:

> **Note:** The following Mermaid diagram uses syntax compatible with Mermaid version 10.7.0. If you encounter a syntax error, ensure your Markdown renderer or tool supports at least this version of Mermaid.

# CS1OP-CW1

## Profile
- **Module Code:** CS1OP  
- **Assignment Report Title:** CS1OP-CW1  
- **Student Number:** 33003767  
- **Actual Hours Spent:** 30  
- **AI Tools Used:** OpenAI/ChatGPT and GitHub Copilot  

**Note to run the program on one line use: mvn -f "pom.xml" clean compile, and the next: mvn -f "pom.xml" exec:java**

**Implementation Highlights**

In the Customer Relations Manager program, the use of Java and HTML as an interface greatly influenced my design format. Due to the need for front-to-backend support, JavaScript was implemented for functionality, and CSS was used on the frontend to help style the Customer Relations Management pages. The CRM (Customer Relationship Management) system was used as a package across each Java file. As Java was integrated with JavaScript, my Main class pulled data from the CRMSystem, which linked to all of the other object classes.

On the frontend, the user can access Customer, Task, and Communication pages to perform the specified requirements. The program was required to handle communication, reporting, and task management between customers. Since we needed an interface for user interaction, I provided a brief instruction guide at the beginning. We were also required to implement three different design patterns: Singleton, Observer, and Factory. These, along with our other Java files, were finally tested.

While creating the advanced program, my assumptions were to use AI as a tool for learning and development. I assumed that all pages could be reviewed and supported by AI for extended assistance. I also assumed that an HTML interface could be used effectively with the help of Maven.

Lastly here is the mermaid diagram:
---

## Diagram

### Class Diagram

```mermaid
%%{ init : { "theme" : "default" } }%%
flowchart TD
      A(["CRMSystem"])
      B(["Customer"])
      C(["Task"])
      D(["Communication"])
      E(["TaskObserver (interface)"])
      F(["TaskNotifier"])

      subgraph CRMSystem Members
        A1["- List<Customer> customers"]
        A2["- List<Task> tasks"]
        A3["- List<Communication> communications"]
        A4["+ getInstance(): CRMSystem"]
        A5["+ addCustomer(Customer)"]
        A6["+ createTask(Task)"]
        A7["+ createCommunication(Communication)"]
        A8["+ getCustomers(): List<Customer>"]
        A9["+ getTasks(): List<Task>"]
        A10["+ getCommunications(): List<Communication>"]
        A11["+ registerObserver(TaskObserver)"]
      end

      subgraph Customer
        B1["- id: int"]
        B2["- name: String"]
        B3["- email: String"]
        B4["- phone: String"]
        B5["+ getId(), getName(), getEmail(), getPhone()"]
      end

      subgraph Task
        C1["- description: String"]
        C2["- dueDate: LocalDate"]
        C3["- customerId: int"]
        C4["- completed: boolean"]
        C5["+ isCompleted(), getDueDate()"]
      end

      subgraph Communication
        D1["- type: String"]
        D2["- content: String"]
        D3["- date: LocalDate"]
        D4["- customerId: int"]
        D5["+ getCustomerId()"]
      end

      subgraph TaskObserver
        E1["+ notify(Task)"]
      end

      subgraph TaskNotifier
        F1["- List<TaskObserver> observers"]
        F2["+ addObserver(TaskObserver)"]
        F3["+ notifyObservers(Task)"]
      end

      %% Relationships
      A --> B
      A --> C
      A --> D
      A --> F
      F --> E
      C --> B
      D --> B
```

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/topics/git/add_files/#add-files-to-a-git-repository) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://csgitlab.reading.ac.uk/ff003767/cs1op-cw1.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://csgitlab.reading.ac.uk/ff003767/cs1op-cw1/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/user/project/merge_requests/auto_merge/)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thanks to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README

Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
