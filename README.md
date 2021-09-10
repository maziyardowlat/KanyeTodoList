# DSTL- Dynamic Student Todo List 

## A daily scheduler for the dynamic and ever-changing plans of Student with Grade Keeping Capabilities

This is a daily planner that is tailored specifically for the **Student**, as this todo-list allows students to have multiple lists open at once.
The main reason why this idea came to be is that I make daily todo lists, but often times miss one step and feel demotivated and will end up re-writing a brand new one from scratch, and this wastes paper.
Therefore, DSPD is the perfect solution for the problem as it allows for the student to view their original plan, and if they make a mistake, they can have both of their lists that can be viewed simultaneously.

Another feature that will be present in this daily planner is the incorporation of a ***Grades*** Tab, where Students can select from a variety of courses, and they can input in their current grades
and the grade that they want to finish the course with. This functions similar to the todo-list, as while this is not a daily task that can be completed like the rest, this will be a work-in-progress
achievement. Various sources have stated that writing down a specific goal will lead to a higher chance of completion, and this is something that I utilize in my daily life as well. Alongside the ability to input in grades, the user will have the ability to make notes
that are specific to the course, and this can allow them to write down a plan, or simply just notes with regards to the course.
While both of these features can be completed by Frankenstein-ing pieces of paper together, the ability to view all the information in one place is the real reason why I am going for this project.
I actively use lists, as well as keeping track of my grades in an excel document, but having the ability to view my original plan alongside of having my grades and information about them available is the main
draw of this app.

<p> <strong> User Stories</strong>

- As a user, I want to be able to add a task to my todo-list
- As a user, I want to be able to remove a task from my todo-list
- As a user, I am able to view the added tasks on my todo-list 
- As a user, I want to be able to add a specific start date, name, and title to my task
- As a user, I want to be able to add a specific targetted time (date) that I want to finish the task under
- As a user, I want to be able to save my TodoList to a file 
- As a user, I want to be able to load my TodoList from a file
  
</p>

<p> <strong> Realized User Stories (Phase 1) </strong>

- You can add a number of tasks to the todo-List
- You can remove any number of tasks from the list, assuming there exist correspinding todo-tasks 
- You can view the tasks that have been added to the todo-list 
- You can add a specific start date, name, title to any todo-item for further clarification
- You can add a specific end date to a task item. 
- You can add a grade to the todo-item, which is displayed seperatley than the todo-item, which will get further 
realized when the GUI is integrated.
  

</p>

<p> <strong> Realized User Stories + Significant Changes (Phase 2) </strong>

- You can save your TodoList to a file
- You can load your TodoList from a file 
- For the grade input, the program does not crash if a non-integer value is inserted. 

</p>

<p> Phase 3 Best way to Utilize the GUI

1. If you have tasks saved, and you open the todoList but do not load the saved tasks in, adding new tasks
overides the saved tasks, so be sure to do that first.
2. To view all of the tasks, you need to play around with the UI a little bit. The best way to do it is to
add a task, save it, close. then repoen, load the task and show it, then add a new task, save, then load and show 
   and this will give you a panel that you can click on to see all of the saved tasks
3. Similar to the save, if you do not load in the tasks from before
4. To have the Image pop up, click on the done button and kanye will pop up
5. The way to save the tasks is to input all the fields, then click the save button 
at the level of the fields, then click the "Save This task Button"
   
6. The way to remove a task is similar, make sure the fields are the exact same as the task you are wanting to remove
the enter it, then click the save button at the input level, then click remove and finally click "Save this task"


</p>

<p>  Phase 4 

Task 2: The one change that I decided to make was making the RemoveTask class robust, and 
this change has been applied to the TodoList class, and all of the required tests have been changed to provision
this addition. Furthermore, other classes have also gotten fixed with the try catch.

Task 3: 

Looking at the current UML diagram, it is not something too complex, and the main reason for this is that
there is there is not much High Cohesion that is going on, and there is tight coupling to an extent. Something that I 
would for sure change would be to split the TaskUI into two different classes, and the main reason for this that 
right now there is an extra task constructor that is used to show the task, and I believe that with more time, 
I could develop the Show Task into another class. That is for sure the most siginifcant change that I would make.


</p>
