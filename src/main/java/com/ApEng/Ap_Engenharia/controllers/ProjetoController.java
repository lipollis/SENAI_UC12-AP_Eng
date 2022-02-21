package com.ApEng.Ap_Engenharia.controllers;

import com.ApEng.Ap_Engenharia.models.Cliente;
import com.ApEng.Ap_Engenharia.models.Projeto;
import com.ApEng.Ap_Engenharia.models.Terceirizado;
import com.ApEng.Ap_Engenharia.repositories.ClienteRepository;
import com.ApEng.Ap_Engenharia.repositories.ProjetoRepository;
import com.ApEng.Ap_Engenharia.repositories.TerceirizadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProjetoController {

    @Autowired
    private TerceirizadoRepository terceirizadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    // GET REQUISITA O FORM DE CADASTRO
    @RequestMapping("/cadastrarProjeto")
    public String form(){ return "projeto/form-projeto";}

    // POST CADASTRAR O PROJETO
    @RequestMapping(value = "/cadastrarProjeto", method = RequestMethod.POST)
    public String form(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarProjeto";
        }

        projetoRepository.save(projeto);
        attributes.addFlashAttribute("mensagem", "Projeto cadastrado com sucesso!");
        return "redirect:/cadastrarProjeto";
    }

    // GET QUE LIST OS PROJETOS
    @RequestMapping("/projetos")
    public ModelAndView listaProjetos(){
        ModelAndView modelAndView = new ModelAndView("projeto/lista-projeto");
        Iterable<Projeto> projetos = projetoRepository.findAll();
        modelAndView.addObject("projetos",projetos);
        return modelAndView;
    }

    // GET QUE MOSTRA OS DETALHES DE CLIENTE, TERCEIRIZADO E PROJETO
    @RequestMapping("/projeto/{id}")
    public ModelAndView detalhesProjeto(@PathVariable("id") long id){
        Projeto projeto = projetoRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("projeto/detalhes-projeto");
        modelAndView.addObject("projeto", projeto);

        Iterable<Cliente> clientes = clienteRepository.findByProjeto(projeto);
        modelAndView.addObject("clientes", clientes);

        Iterable<Terceirizado> terceirizados = terceirizadoRepository.findByProjeto(projeto);
        modelAndView.addObject("terceirizados", terceirizados);

        return modelAndView;
    }

    // REQUISIÇÃO PARA DELETAR
    @RequestMapping("/deletarProjeto")
    public String deletarProjeto(long id){
        Projeto projeto = projetoRepository.findById(id);
        projetoRepository.delete(projeto);
        return "redirect:/projetos";
    }

    // POST QUE ADICIONA CLIENTE E TERCEIRIZADO AO PROJETO
    @RequestMapping(value = "/projeto/{id}", method = RequestMethod.POST)
    public String detalhesProjetoPost(@PathVariable("id") long id, @Valid Cliente cliente,
                                      @Valid Terceirizado terceirizado,
                                      BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos.");
            return "redirect:/projeto/{id}";
        }
        Projeto projeto = projetoRepository.findById(id);
        cliente.setProjeto(projeto);
        clienteRepository.save(cliente);

        terceirizado.setProjeto(projeto);
        terceirizadoRepository.save(terceirizado);

        attributes.addFlashAttribute("mensagem", "Cliente adicionado com sucesso!");
        return "redirect:/projeto/{id}";
    }

    // DELETE PROJETO PELO ______
    /*
    @RequestMapping("/deletarProjeto")
    public String deletarProjeto(long id){
        Projeto projeto = projetoRepository.findById(id);
        Cliente cliente = projeto.getCliente();
        String id = "" + cliente.getId();

        Terceirizado terceirizado = projeto.getTerceirizado();
        id = "" + terceirizado.getId();

        projetoRepository.delete(projeto);

        return "redirect:/projeto/" + id;
    }*/

    // MÉTODOS UPDATE PARA PROJETO
    // GET CHAMA O FORMULÁRIO DE EDIÇÃO DO PROJETO
    @RequestMapping("/editar-projeto")
    public ModelAndView editarProjeto(long id){
        Projeto projeto = projetoRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("projeto/update-projeto");
        modelAndView.addObject("projeto", projeto);
        return modelAndView;
    }

    // POST DO FORM QUE ATUALIZA CLIENTE
    @RequestMapping(value = "/editar-projeto", method = RequestMethod.POST)
    public String updateProjeto(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes){
        projetoRepository.save(projeto);
        attributes.addFlashAttribute("sucess", "Projeto alterado com sucesso!");

        long idLong = projeto.getId();
        String id = "" + idLong;
        return "redirect:/projeto/" + id;
    }
}
