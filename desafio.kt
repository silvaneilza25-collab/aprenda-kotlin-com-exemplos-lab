
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")

        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("O usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }

    fun duracaoTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val usuario1 = Usuario("Neilza")
    val usuario2 = Usuario("Edson")
    val usuario3 = Usuario("Michaell")

    val conteudo1 = ConteudoEducacional("Kotlin Básico", 120)
    val conteudo2 = ConteudoEducacional("POO com Kotlin", 100)
    val conteudo3 = ConteudoEducacional("Estruturas de Dados", 80)

    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudo1, conteudo2, conteudo3)
    )

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)

    println("Formação: ${formacaoKotlin.nome}")
    println("Nível: ${formacaoKotlin.nivel}")
    println("Duração total: ${formacaoKotlin.duracaoTotal()} minutos")
    println("Inscritos:")
    formacaoKotlin.inscritos.forEach { println(it.nome) }
}
