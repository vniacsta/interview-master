package org.academiadecodigo.asynctomatics.interviewmaster.controller.web;

import org.academiadecodigo.asynctomatics.interviewmaster.converter.*;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Answer;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Question;
import org.academiadecodigo.asynctomatics.interviewmaster.service.AnswerService;
import org.academiadecodigo.asynctomatics.interviewmaster.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class BackOfficeController {

    private QuestionService questionService;
    private AnswerService answerService;
    private QuestionDtoToQuestion questionDtoToQuestion;
    private QuestionToQuestionDto questionToQuestionDto;
    private AnswerToAnswerDto answerToAnswerDto;
    private AnswerDtoToAnswer answerDtoToAnswer;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setQuestionDtoToQuestion(QuestionDtoToQuestion questionDtoToQuestion) {
        this.questionDtoToQuestion = questionDtoToQuestion;
    }

    @Autowired
    public void setQuestionToQuestionDto(QuestionToQuestionDto questionToQuestionDto) {
        this.questionToQuestionDto = questionToQuestionDto;
    }

    @Autowired
    public void setAnswerToAnswerDto(AnswerToAnswerDto answerToAnswerDto) {
        this.answerToAnswerDto = answerToAnswerDto;
    }

    @Autowired
    public void setAnswerDtoToAnswer(AnswerDtoToAnswer answerDtoToAnswer) {
        this.answerDtoToAnswer = answerDtoToAnswer;
    }


    // get request to show list of questions and answers available in the DB
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String listQuestions(Model model) {
        model.addAttribute("quiz", questionToQuestionDto.convert((Question) questionService.list()));
//        model.addAttribute("quiz", answerToAnswerDto.convert(answerService.list()));
        return "index";
    }

    // get request to add a new question
    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addQuestion(Model model) {
        model.addAttribute("question", new QuestionDto());
        model.addAttribute("answer", new AnswerDto());
        return "add-edit";
    }

    // get request to edit a question
    @RequestMapping(method = RequestMethod.GET, path = "/{id}/edit")
    public String editQuestion(@PathVariable Integer id, Model model) {
        model.addAttribute("question", questionToQuestionDto.convert(questionService.get(id)));
        model.addAttribute("answer", answerToAnswerDto.convert((Answer) answerService.list(id)));
//        model.addAttribute("correct", answerToAnswerDto.convert((Answer) answerService.isCorrect()));
        return "add-edit";
    }

    // post request to save a question and answers
    @RequestMapping(method = RequestMethod.POST, path = "/")
    public String save(@Valid @ModelAttribute("question") QuestionDto questionDto, BindingResult bindingResultQ,
                       @Valid @ModelAttribute("answer") AnswerDto answerDto, BindingResult bindingResultA) {

        if (bindingResultQ.hasErrors() || bindingResultA.hasErrors()) {
            return "add-edit";
        }

        Question savedQuestion = questionService.save(questionDtoToQuestion.convert(questionDto));
        questionService.addAnswer(savedQuestion.getId(), answerDtoToAnswer.convert(answerDto));
        return "redirect:/index";
    }

}
