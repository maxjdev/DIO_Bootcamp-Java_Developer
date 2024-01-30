import br.com.desafio.dominio.Bootcamp;
import br.com.desafio.dominio.Curso;
import br.com.desafio.dominio.Dev;
import br.com.desafio.dominio.Mentoria;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        Curso curso2 = new Curso();
        Mentoria mentoria = new Mentoria();

        curso1.setTitulo("Curso Back-End Java");
        curso1.setDescricao("Especialista Back-End Java");
        curso1.setCargaHoraria(8);

        curso2.setTitulo("Curso Front-End JavaScript");
        curso2.setDescricao("Front-End JS");
        curso2.setCargaHoraria(8);

        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Mentoria Especialista em Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição bootcamp java developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devMax = new Dev();
        devMax.setNome("Max");
        devMax.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + devMax.getConteudosInscritos());
        devMax.progredir();
        devMax.progredir();
        devMax.progredir();
        System.out.println("------*> Progressão");
        System.out.println("Conteúdos inscritos: " + devMax.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos: " + devMax.getConteudosConcluidos());
        System.out.println("Max Developer EXP: " + devMax.calcularTotalXP());

        System.out.println("------*> Dev 2");

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("------*> Progressão");
        System.out.println("Conteúdos inscritos: " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos: " + devCamila.getConteudosConcluidos());
        System.out.println("Max Developer EXP: " + devCamila.calcularTotalXP());
    }
}