package org.lox.recycler

class Student (var fname: String, var lname: String, var score: Int){
    
    fun print(){
       print("${fname} ${lname} score : ${score}")
    }

    fun printScore(): String{
        return "score : ${score}"
    }

    fun printName(): String{
        return "${fname} ${lname}"
    }

    fun printStatus(): String{
        if (score >= 50) {
            return "Pass"
        } else {
            return "Fail"
        }
    }
}