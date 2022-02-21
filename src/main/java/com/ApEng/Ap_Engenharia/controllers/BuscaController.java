package com.ApEng.Ap_Engenharia.controllers;

import com.ApEng.Ap_Engenharia.repositories.ClienteRepository;
import com.ApEng.Ap_Engenharia.repositories.ParceiroRepository;
import com.ApEng.Ap_Engenharia.repositories.ProjetoRepository;
import com.ApEng.Ap_Engenharia.repositories.TerceirizadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuscaController {
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ParceiroRepository parceiroRepository;

    @Autowired
    private TerceirizadoRepository terceirizadoRepository;


    //GET
    @RequestMapping("/")
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    //POST
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {

        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Resultados da busca por " + buscar;

        if(nome.equals("nomeProjeto")) {
            mv.addObject("projetos", projetoRepository.findByNomesProjetos(buscar));

        }else if(nome.equals("nomeCliente")) {
            mv.addObject("clientes", clienteRepository.findByNomesClientes(buscar));

        }else if(nome.equals("nomeParceiro")) {
            mv.addObject("parceiros", parceiroRepository.findByNomesParceiros(buscar));

        }else if(nome.equals("nomeTerceirizado")) {
            mv.addObject("terceirizados", terceirizadoRepository.findByNomesTerceirizados(buscar));

        }else {
            mv.addObject("projetos", projetoRepository.findByNomesProjetos(buscar));
            mv.addObject("clientes", clienteRepository.findByNomesClientes(buscar));
            mv.addObject("parceiros", parceiroRepository.findByNomesParceiros(buscar));
            mv.addObject("terceirizados", terceirizadoRepository.findByNomesTerceirizados(buscar));
        }

        mv.addObject("mensagem", mensagem);

        return mv;
    }
}
