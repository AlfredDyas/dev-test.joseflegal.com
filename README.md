# Josef coding challenge

Hello 👋 & welcome to the Josef coding challenge. We appreciate you taking the time to complete the assignment, and we're excited about the prospect of you joining the team!

The goal of this assignment is to get a sense of how you think and solve problems. If you're having build issues 🔧 with the project, please don't hesitate to contact us.

The challenge is to build upon a simple Vue.js application.

You may want to install [Vue Dev Tools](https://chrome.google.com/webstore/detail/vuejs-devtools/nhdogjmejiglipccpnnnanhbledajbpd?hl=en) to enrich your Vue dev experience.

## How it works

- Fork this repo into your account
- Make a new branch
- When you are finished, make a PR on your fork, and invite the person specified in the email to your fork
- We will take a look at your solution, and we might ask you several questions after

## Coding task

### Frontend

In `src/views/Layout.vue`, you'll find a component loading data from an API.

1. Render the list of files from the API.

2. Create a reusable component to render the items, using a combination of [props](https://vuejs.org/v2/api/#props) and [slots](https://vuejs.org/v2/api/#v-slot).

3. The design / UI is open for you to decide 🎨. Try to use some of the scss variables in `src/styles/resources/_variables.scss` to give it a Josef feel.

4. Create a [computed property](https://vuejs.org/v2/guide/computed.html) that takes the file's data and filters it for tags that include `kitten` then sorts it by date.

### Backend

In `src/views/Rules.vue` you'll find a Vue.js view with detailed instructions about the problem.

1. Modify the `checkGroup` function in the file so it returns `true` if all rules and groups apply, otherwise `false`.

2. Try your best to implement the task in an efficient and elegant way.

#### Extra credit

1. The data is currently being managed locally in `src/views/Layout.vue` and `src/views/Rules.vue`, migrate it to a [vuex module](https://vuex.vuejs.org/guide/modules.html) in `src/store`. _See example in `src/store/user`._
2. Write some unit tests for your challenge in `/tests/unit`.

### QA

In `src/views/QA.vue` you'll find a Vue.js view that we want you to test 🧐.

1. **API testing:** Using [Postman](https://www.postman.com/)(or a tool of your preference), test functionality of the REST API for the `entity` object. Validate listing, creating, editing and deleting objects.
Additionally, test a uniqueness requirement for `entity.id` property. Objects can be accessed and modified using requests:

```
  GET    http://localhost:3000/entities  
  GET    http://localhost:3000/entities/[id] 
  POST   http://localhost:3000/entities  
  PUT    http://localhost:3000/entities/[id] 
  DELETE http://localhost:3000/entities/[id] 
```

2. **e2e frontend testing:** Using [Cypress](https://www.cypress.io/)(or a tool of your preference) test form submission on the QA page.
3. **Extra credit:** Using [Lighthouse](https://developers.google.com/web/tools/lighthouse) run an audit of the QA page and document your performance and acesebility findings.

When done, save required files in the `tests/` folder and add instructions to the `README.md` 📝. 
 - Be sure and include as much information as you can about how you are testing and what future tools improvements you might add going forward.

## Getting the project running

```bash

# Fork this project, then clone your fork
git clone https://github.com/...

cd dev-test.joseflegal.com

# Install dependencies
nvm install
npm install

# Start development server
npm run dev

# Visit http://localhost:9001
```

## Scripts

| Script              | Description                                                                     |
| ------------------- | ------------------------------------------------------------------------------- |
| `npm run dev`       | Starts json server on 3000 and Compiles and hot-reloads for development on 9001 |
| `npm run test:unit` | Run your unit tests                                                             |
| `npm run test:e2e`  | Run your end-to-end tests                                                       |
| `npm run lint`      | Lints and fixes files                                                           |
| `npm run build`     | Compiles and minifies for production                                            |

## Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).



##Testing Instructions 

**Api Testing** 
- Pre requisite 
  Make sure the application is running using "npm run dev" command 
- Import the json files(Josef-collection.js and Josef-env.json) placed under the folder - \tests\api_test_alfred . 
  These are the files for the collection and environment that are requird to run the tests in postman 
- I have used newman reporting to generate reports  , a sample report(Josef Copy-2021-12-18-10-01-45-360-0.html) generated is placed here - \tests\api_test_alfred\newman 
- Installation instructions for newman can be found here - https://learning.postman.com/docs/running-collections/using-newman-cli/command-line-integration-with-newman/



** Automated testing **
I have used the cucumber bdd framework to create automated tests . 

- Tools used : 
  Katalon recorder - chrome extension
  IntelliJ IDE - can be downloaded from https://www.jetbrains.com/idea/download/?fromIDE=#section=windows
 
- Pre requisites 
  Install java sdk (16.0.2)- https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html
 

- Instructions to run automated tests : 
  *After installation of IntelliJ and java sdk open the project using IntelliJ ,  placed in \automation_for_forms_alfred\Josef form
  *Run the Josf.feature file , this creates a report with the passed /failed tests with a link in the console
  *A sample report (Cucumber Reports.pdf) can be found here - \tests\automation_for_forms_alfred\example report or https://reports.cucumber.io/reports/c6ab18d7-9206-4dd0-bbd1-65ff98c0e54a

- Assumptions for testing the form 
Name field should accept only charachters 
Name field allows name with spaces .Eg: Alfred Dyas Don Bosco
Name field does not allow numbers 
Name field does not allow special charachters
Name field does not allow single alphabet 

Email field should accept email format  Eg: alfred.dyas@gmail.com 
Email fied should not allow special charachters such as *^&%$#!!*()

Age field should allow only numbers and not alphabets or special charachters 
Age field should be between 0 and 120
Age fiels should not acccept negative values or values above 120

Phone field should allow numbers 
Phone field should not allow alphabets 
Phone field should not allow special charachters 
Phone field allows values of format +61431987010
Phone field does not allow numbers like 8888888888888888888888

Test results :
Test Data for successfull form submision  
		 |Name|Email|Age|Phone|
		 |Alfred|Afred.dyas@gmail.com|76|8765456784| - Pass
		 |Alfred|Afred.dyas@gmail.com|76|+61431987010| - Pass 
		 |Alfred|Afred.dyas@gmail.com|76|9987678986| - Pass
		 |Afred Dyas Don Bosco|Afred.dyas@gmail.com|55|8888| - Pass 
 
 Test DAta for which the form should fail 
      |Name|Email|Age|Phone|
      |    |     |   |     | - Pass
      ||Afred.dyas@gmail.com|55|8888|  - Pass
      |A|Afred.dyas@gmail.com|55|8888| - Fail (it cant take name as a single charachter )
      |9999|Afred.dyas@gmail.com|55|8888| - Fail (it cant take numbers as a name )
      |*|Afred.dyas@gmail.com|55|8888| - Fail (it cant take special charachters as name )

      |Alfred||88|8765456784|-Pass
      |Alfred|aaa|88|8765456784|-Pass
      |Alfred|99999|88|8765456784|-Pass
      |Alfred|a@:.com|88|8765456784|-Pass
      |Alfred|a@a|88|8765456784| - Fail  (its taking a@a.com this is incorrect )
      |Alfred|aaaaaaaaaa@tetwetfgdf^&*^&^&(.com|88|8765456784|- Pass
      |Alfred|+++^^^|88|8765456784|-Pass

      |Alfred|Afred.dyas@gmail.com||8765456784| - Pass
      |Alfred|Afred.dyas@gmail.com|0|8765456784|- Pass
      |Alfred|Afred.dyas@gmail.com|hghg|8765456784|- pass
      |Alfred|Afred.dyas@gmail.com|-7|8765456784| - Fail (its taking negative numbers as age )
      |Alfred|Afred.dyas@gmail.com|88888888888888|8765456784| - Fail (its taking age as 88888888888888)
      |Alfred|Afred.dyas@gmail.com|;;|8765456784| -  Pass

      |Alfred|Afred.dyas@gmail.com|76|| - Pass
      |Alfred|Afred.dyas@gmail.com|76|aaa|- Fail (It is taking aaa as phone number )
      |Alfred|Afred.dyas@gmail.com|76|:::| - Fail (It is taking special charachters as phoen number )
      |Alfred|Afred.dyas@gmail.com|76|99999999999999999999999| - Fail (It is taking 999999999999999999 as phne numbber )





** Lighthouse report **
A sample lighthouse report(localhost_9001-20211221T195342.hml) is generated and placed here - \tests\lighthouse_report_alfred

Perfomance metric - 52 
Accessibility metric - 69 and can be improved with the suggestion in the report  
