package entidades;

public class Paciente implements Comparable<Paciente> {

    private String nome;
    private int nivelUrgencia;
    private int tempoEsperaMinutos;
    private boolean grupoVulneravel;

    public Paciente(String nome, int nivelUrgencia, int tempoEsperaMinutos, boolean grupoVulneravel) {
        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
        this.tempoEsperaMinutos = tempoEsperaMinutos;
        this.grupoVulneravel = grupoVulneravel;
    }

    @Override
    public int compareTo(Paciente outro) {
        if (this.nivelUrgencia != outro.nivelUrgencia) {
            return this.nivelUrgencia - outro.nivelUrgencia;
        }
        if (this.tempoEsperaMinutos != outro.tempoEsperaMinutos) {
            return this.tempoEsperaMinutos - outro.tempoEsperaMinutos;
        }
        if (this.grupoVulneravel != outro.grupoVulneravel) {
            return this.grupoVulneravel ? 1 : -1;
        }
        return 0;
    }

    public String getNome() {
        return nome;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public int getTempoEsperaMinutos() {
        return tempoEsperaMinutos;
    }

    public boolean isGrupoVulneravel() {
        return grupoVulneravel;
    }

    public String getCorUrgencia() {
        return switch (nivelUrgencia) {
            case 5 -> "Vermelho";
            case 4 -> "Laranja";
            case 3 -> "Amarelo";
            case 2 -> "Verde";
            case 1 -> "Azul";
            default -> "Desconhecida";
        };
    }

    @Override
    public String toString() {
        return String.format("%s (Nível %d/%s, %dmin, %s)",
                nome,
                nivelUrgencia,
                getCorUrgencia(),
                tempoEsperaMinutos,
                grupoVulneravel ? "vulnerável" : "geral");
    }
}
