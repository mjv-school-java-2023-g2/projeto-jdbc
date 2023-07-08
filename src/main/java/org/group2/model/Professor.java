public class Professor {
	private LocalDate dataNascimento;
	private LocalTime cargaHorario;
	private Double valorHora;
	private boolean estrangeiro;
	private Integer horasDisponiveis;
	private String biografia;
	private LocalDateTime dataHoraCadastro;

	public Professor (
		LocalDate dataNascimento,
		LocalTime cargaHorario,
		Double valorHora,
		boolean estrangeiro,
		Integer horasDisponiveis,
		String biografia,
		LocalDateTime dataHoraCadastro
	) {
		this.dataNascimento = dataNascimento;
		this.cargaHorario = cargaHorario;
		this.valorHora = valorHora;
		this.estrangeiro = estrangeiro;
		this.horasDisponiveis = horasDisponiveis;
		this.biografia = biografia;
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Integer getId() { return id; }
	public String getNome() { return nome; }
	public Double getValorHora() { return valorHora; }
	public boolean isEstrangeiro() { return estrangeiro; }
	public Integer getHorasDisponiveis() { return horasDisponiveis; }
	public String getBiografia() { return biografia; }
	public LocalDate getDataNascimento() { return dataNascimento; }
	public LocalTime getCargaHorario() { return cargaHorario; }
	public LocalDateTime getDataHoraCadastro() { return dataHoraCadastro; }

	public void setId (Integer id) { this.id = id; }
	public void setNome (String nome) { this.nome = nome; }
	public void setEstrangeiro (boolean estrangeiro) { this.estrangeiro = estrangeiro; }
	public void setHorasDisponiveis (Integer horasDisponiveis) { this.horasDisponiveis = horasDisponiveis; }
	public void setBiografia (String biografia) { this.biografia = biografia; }
	public void setDataNascimento (LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
	public void setCargaHorario (LocalTime cargaHorario) { this.cargaHorario = cargaHorario; }
	public void setDataHoraCadastro (LocalDateTime dataHoraCadastro) { this.dataHoraCadastro = dataHoraCadastro; }
}
