/*
===============================================================================
                    LSP vs ISP (Real World Example)
===============================================================================

Scenario
--------

A company has different employees.

- Developer
- Manager
- Intern

We will compare LSP and ISP using this scenario.

===============================================================================
*/
package solid;

public class LSP_vs_ISP {

    public static void main(String[] args) {

        System.out.println("========== LSP ==========");

        FullTimeEmployee developer = new Developer();

        developer.work();

        developer.getSalary();

        System.out.println("\n========== ISP ==========");

        Developer developer2 = new Developer();

        developer2.work();
        // developer2.writeCode();

        Manager manager = new Manager();

        manager.work();
        // manager.manageTeam();

    }

}

/*
 * =============================================================================
 * ==
 * LSP
 * =============================================================================
 * ==
 * 
 * Imagine every FullTimeEmployee
 * 
 * - works
 * - receives salary
 * 
 * Every child must respect this behavior.
 * 
 * =============================================================================
 * ==
 */

class FullTimeEmployee {

    public void work() {

        System.out.println("Employee is working.");

    }

    public void getSalary() {

        System.out.println("Monthly salary received.");

    }

}

class Developer extends FullTimeEmployee {

    @Override
    public void work() {

        System.out.println("Developer is writing code.");

    }

}

class Manager extends FullTimeEmployee {

    @Override
    public void work() {

        System.out.println("Manager is managing the team.");

    }

}

/*
 * Imagine we create:
 * 
 * class Volunteer extends FullTimeEmployee
 * 
 * and then:
 * 
 * @Override
 * public void getSalary(){
 * 
 * throw new UnsupportedOperationException();
 * 
 * }
 * 
 * Now Volunteer cannot replace FullTimeEmployee.
 * 
 * This violates LSP.
 * 
 * The problem is inheritance.
 * 
 * =============================================================================
 * ==
 */

/*
 * =============================================================================
 * ==
 * ISP
 * =============================================================================
 * ==
 * 
 * Now suppose the company creates ONE interface.
 * 
 * =============================================================================
 * ==
 */

interface Employee {

    void work();

    void writeCode();

    void manageTeam();

}

/*
 * Developer writes code.
 * 
 * Manager manages the team.
 * 
 * But because of one huge interface,
 * both classes must implement everything.
 * 
 * This violates ISP.
 * 
 * =============================================================================
 * ==
 */

class Developer2 implements Employee {

    @Override
    public void work() {

        System.out.println("Developer working.");

    }

    @Override
    public void writeCode() {

        System.out.println("Writing Java Code.");

    }

    @Override
    public void manageTeam() {

        // meaningless
        throw new UnsupportedOperationException();

    }

}

class Manager2 implements Employee {

    @Override
    public void work() {

        System.out.println("Manager working.");

    }

    @Override
    public void writeCode() {

        // meaningless
        throw new UnsupportedOperationException();

    }

    @Override
    public void manageTeam() {

        System.out.println("Managing Team.");

    }

}

/*
 * Correct ISP Design
 * 
 * interface Workable
 * 
 * interface Coder
 * 
 * interface Leader
 * 
 * Developer implements Workable, Coder
 * 
 * Manager implements Workable, Leader
 * 
 * Nobody implements unnecessary methods.
 * 
 * =============================================================================
 * ==
 * 
 * FINAL DIFFERENCE
 * 
 * LSP
 * 
 * Problem
 * -------
 * 
 * Wrong inheritance.
 * 
 * Child cannot safely replace parent.
 * 
 * Example
 * 
 * Volunteer extends FullTimeEmployee
 * 
 * but cannot receive salary.
 * 
 * Wrong.
 * 
 * -----------------------------------------------------------------------------
 * --
 * 
 * ISP
 * 
 * Problem
 * -------
 * 
 * Wrong interface design.
 * 
 * Developer forced to manage team.
 * 
 * Manager forced to write code.
 * 
 * Wrong.
 * 
 * -----------------------------------------------------------------------------
 * --
 * 
 * Easy Rule
 * 
 * LSP
 * 
 * "Is inheritance correct?"
 * 
 * ISP
 * 
 * "Is the interface too big?"
 * 
 * =============================================================================
 * ==
 */