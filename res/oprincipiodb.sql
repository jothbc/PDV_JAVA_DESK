-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04-Nov-2019 às 21:48
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oprincipiodb`
--
CREATE DATABASE IF NOT EXISTS `oprincipiodb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `oprincipiodb`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `boleto`
--

CREATE TABLE `boleto` (
  `id` int(11) NOT NULL,
  `fornecedor` int(11) DEFAULT NULL,
  `codigo` varchar(44) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `vencimento` date DEFAULT NULL,
  `pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `boleto`
--

INSERT INTO `boleto` (`id`, `fornecedor`, `codigo`, `valor`, `vencimento`, `pago`) VALUES
(5, 2, '10497791200000204472719304000100040009565944', 204.47, '2019-06-06', '2019-06-06'),
(6, 1, '23791793400000090622657040000015284300009500', 90.62, '2019-06-28', '2019-06-26'),
(8, 1, '23792796400000090622657040000015284400009500', 90.62, '2019-07-28', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE `caixa` (
  `seq` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `fundo` double DEFAULT '0',
  `dinheiro` double DEFAULT '0',
  `credito` double DEFAULT '0',
  `debito` double DEFAULT '0',
  `crediario` double DEFAULT '0',
  `sangria` double DEFAULT '0',
  `suprimento` double DEFAULT '0',
  `inicial` int(11) DEFAULT NULL,
  `final` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  `ip` varchar(45) DEFAULT NULL,
  `dinheiro_inf` double DEFAULT '0',
  `pos_inf` double DEFAULT '0',
  `crediario_inf` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `caixa`
--

INSERT INTO `caixa` (`seq`, `usuario_id`, `fundo`, `dinheiro`, `credito`, `debito`, `crediario`, `sangria`, `suprimento`, `inicial`, `final`, `data`, `status`, `ip`, `dinheiro_inf`, `pos_inf`, `crediario_inf`) VALUES
(1, 1, 0, 345, 0, 0, 360, 0, 0, 20, NULL, '2019-06-26', 1, '10.0.0.100', 0, 0, 0),
(2, 1, 0, 119.9, 0, 0, 119.8, 0, 0, 22, NULL, '2019-07-30', 1, '10.0.0.103', 0, 0, 0),
(3, 1, 0, 68, 0, 0, 0, 0, 0, 24, NULL, '2019-10-02', 1, '10.0.0.104', 0, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `crediario` double DEFAULT NULL,
  `aniversario` date DEFAULT NULL,
  `credito` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cpf`, `telefone`, `email`, `crediario`, `aniversario`, `credito`) VALUES
(1, 'Consumidor Final', NULL, NULL, NULL, 0, NULL, NULL),
(3, 'JONATHAN', NULL, NULL, NULL, 0, NULL, 0),
(4, 'RAYSLLA', '092.459.469-16', '123456', 'jothbc', 0, '2001-01-10', 0),
(5, 'KLEITON SILVA DE PAULA', '080.088.449-30', '984274334', 'kleiton.grasi@gmail.com', 0, '1990-11-28', 0),
(6, 'GISELE AGOSTINELLI ', '039.449.329-00', '43 984625664', 'giagostinellisakamoto@gmail.com', 0, '1982-04-05', 0),
(7, 'ROSI', NULL, '(47)99947140', NULL, 0, NULL, 0),
(8, 'IRMÃO SAMUEL', NULL, NULL, NULL, 0, NULL, 0),
(9, 'PASTOR ADONIAS', NULL, NULL, NULL, 0, NULL, 109),
(10, 'IRMÃ ANGELA', NULL, NULL, NULL, 0, NULL, 60),
(11, 'IRMÃO LUIZ PORTÃO', NULL, NULL, NULL, 0, NULL, 0),
(12, 'LEANDRO CAMPOS ', NULL, '99029673', NULL, 0, NULL, 0),
(13, 'MARLUSA RUA', NULL, NULL, NULL, 0, NULL, 18.9),
(14, 'SIDMARA RUA RECICLADO', NULL, NULL, NULL, 0, NULL, 18.9),
(15, 'FRANCIANNI PROF KAYRON', NULL, '999441244', NULL, 0, NULL, 18.9),
(16, 'ELBA LEO SCOOTER', NULL, '992100998', NULL, 0, NULL, 0),
(17, 'VIVIANE SEARA', '039.396.259-81', '(48)99919-3655', 'viviseararock@yahoo.com.br', 0, '1983-05-31', 0),
(18, 'ANGELA ', NULL, NULL, NULL, 0, NULL, 0),
(19, 'THAIS DEMILLUS', NULL, '47 996532443', NULL, 0, NULL, 0),
(20, 'LÉO LEX MOTORS', NULL, NULL, NULL, 0, NULL, 140),
(21, 'MARCIA EVANGELISMO ', NULL, NULL, NULL, 0, NULL, 0),
(22, 'ALINE EVANGELISMO ', NULL, '47 99953-1445', NULL, 0, '1986-10-26', 0),
(23, 'DÉBORA ', NULL, '999340279', NULL, 0, NULL, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `combo`
--

CREATE TABLE `combo` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `produto` varchar(20) DEFAULT NULL,
  `quantidade` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contas`
--

CREATE TABLE `contas` (
  `id` int(11) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `vencimento` date DEFAULT NULL,
  `pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `controle`
--

CREATE TABLE `controle` (
  `id` int(11) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `chave` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `nome`, `chave`) VALUES
(46, 'CASAS DA ÁGUA', 1),
(47, 'DEPECIL     (116441)', 2),
(48, 'CPM OFFICE', 3),
(49, 'L.A TINTAS', 4),
(50, 'WILLY AVIAMENTOS', 5),
(51, 'KARSTEN TEXTIL LTDA', 6),
(52, 'SOCIEDADE BÍBLICA DO BRASIL                    ', 7),
(53, 'JC DISTRIBUIDORA', 8),
(54, 'ARGAFIX MATERIAL DE CONSTRUÇÃO', 9),
(55, 'TAMOYO', 10),
(56, ' NACIONAL DISTRIBUIDORA', 11),
(57, 'PAPELARIA COR DE ROSA  ', 12),
(58, 'CENTRO COMERCIAL DE ALIMENTOS LTDA', 13),
(59, 'COFERPAN COM CAT. PROD PANIFICACAO LTDA', 14),
(60, 'CELESC', 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor_conta`
--

CREATE TABLE `fornecedor_conta` (
  `id` int(11) NOT NULL,
  `chave` int(11) NOT NULL,
  `banco` int(11) DEFAULT '0',
  `numero` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor_conta`
--

INSERT INTO `fornecedor_conta` (`id`, `chave`, `banco`, `numero`) VALUES
(38, 1, 237, '400000090622657040000015284'),
(39, 2, 104, '4000'),
(40, 3, 0, NULL),
(41, 4, 0, NULL),
(42, 5, 0, NULL),
(43, 6, 0, NULL),
(44, 7, 0, NULL),
(45, 8, 0, NULL),
(46, 9, 0, NULL),
(47, 10, 0, NULL),
(48, 11, 0, NULL),
(49, 12, 0, NULL),
(50, 13, 341, '2535'),
(51, 14, 237, '0000'),
(52, 15, 836, '0102');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor_info`
--

CREATE TABLE `fornecedor_info` (
  `chave` int(4) NOT NULL,
  `cnpj` varchar(50) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ie` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor_info`
--

INSERT INTO `fornecedor_info` (`chave`, `cnpj`, `cpf`, `telefone`, `email`, `ie`) VALUES
(1, '13.501.187/0009-06', NULL, '3367-4144', 'crediario.f06@casasdaagua.com.br', NULL),
(2, '00.842.602/0001-96', NULL, '08006422244', 'televendas2@depecil.com.br', NULL),
(3, '17.994.632/0001-10', NULL, NULL, 'vendas@cpmoffice.com .br', NULL),
(4, NULL, NULL, '3366-2124', NULL, NULL),
(5, '06.372.158/0001-79', NULL, '3363-3377', NULL, NULL),
(6, '16.605.598/0003-44', NULL, '3331-4000', NULL, '257.829.172'),
(7, '33.579.376/0011-23', NULL, '08007278888', 'guilherme.carvalho@sbb.org.br', NULL),
(8, '06.027.929/0001-90', NULL, '3241-2621', NULL, '254.683.983'),
(9, '02.568.597/0001-09', NULL, '3363-7398', NULL, NULL),
(10, '76.842.285/0001-70', NULL, '3348-1122', NULL, NULL),
(11, '07.295.822/0002-77', NULL, NULL, NULL, NULL),
(12, '02.486.117/0001-52', NULL, '3367-0894', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento_pdv`
--

CREATE TABLE `pagamento_pdv` (
  `seq` int(11) NOT NULL,
  `movimento` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `troco` double DEFAULT NULL,
  `dinheiro` double DEFAULT NULL,
  `credito` double DEFAULT NULL,
  `debito` double DEFAULT NULL,
  `crediario` double DEFAULT NULL,
  `desconto` double DEFAULT NULL,
  `data` date DEFAULT NULL,
  `pago` tinyint(1) DEFAULT NULL,
  `data_pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pagamento_pdv`
--

INSERT INTO `pagamento_pdv` (`seq`, `movimento`, `total`, `troco`, `dinheiro`, `credito`, `debito`, `crediario`, `desconto`, `data`, `pago`, `data_pago`) VALUES
(24, 1, 100, 0, 0, 0, 0, 100, 0, '2019-05-21', 1, '2019-08-15'),
(25, 2, 100, 0, 0, 0, 0, 55, 45, '2019-05-21', 1, '2019-08-15'),
(26, 3, 109.9, 0.1, 90, 0, 0, 0, 20, '2019-06-12', 1, NULL),
(27, 4, 169.8, 0, 85, 0, 0, 84.8, 0, '2019-06-12', 1, '2019-08-15'),
(28, 5, 221.6, 0, 0, 0, 0, 215.79, 5.81, '2019-06-14', 0, NULL),
(29, 6, 31.8, 0, 30, 0, 0, 1.8, 0, '2019-06-14', 0, NULL),
(30, 7, 109.9, 0, 0, 0, 0, 109.9, 0, '2019-06-14', 0, NULL),
(31, 8, 92.8, 0, 0, 0, 0, 92.8, 0, '2019-06-14', 0, NULL),
(32, 9, 18.9, 0, 0, 0, 0, 18.9, 0, '2019-06-14', 0, NULL),
(33, 10, 18.9, 0, 0, 0, 0, 18.9, 0, '2019-06-14', 0, NULL),
(34, 11, 18.9, 0, 0, 0, 0, 18.9, 0, '2019-06-14', 1, '2019-08-15'),
(35, 12, 18.9, 0, 0, 0, 0, 18.9, 0, '2019-06-14', 0, NULL),
(36, 13, 253.5, 0, 70, 145.8, 0, 0, 37.7, '2019-06-17', 1, NULL),
(37, 14, 100, 0, 85, 0, 0, 0, 15, '2019-06-17', 1, NULL),
(38, 15, 20, 0, 15, 0, 0, 0, 5, '2019-06-17', 1, NULL),
(39, 16, 139.9, 0, 0, 125.68, 0, 0, 14.22, '2019-06-17', 1, NULL),
(40, 17, 100, 0, 0, 0, 0, 20, 80, '2019-06-19', 0, NULL),
(41, 18, 109.9, 0, 0, 0, 0, 104.4, 5.5, '2019-06-22', 1, '2019-08-15'),
(42, 19, 109.9, 0, 104.4, 0, 0, 0, 5.5, '2019-06-26', 1, NULL),
(43, 20, 100, 0, 50, 0, 0, 0, 50, '2019-07-12', 1, NULL),
(44, 21, 100, 0, 60, 0, 0, 0, 40, '2019-07-12', 1, NULL),
(45, 22, 19.9, 0, 19.9, 0, 0, 0, 0, '2019-07-30', 1, NULL),
(46, 23, 219.8, 0, 100, 0, 0, 119.8, 0, '2019-08-15', 0, NULL),
(47, 24, 42.9, 7.1, 50, 0, 0, 0, 0, '2019-10-02', 1, NULL),
(48, 25, 18.9, 0, 18, 0, 0, 0, 0.9, '2019-10-02', 1, NULL),
(49, 26, 134.9, 0, 110, 0, 0, 0, 24.9, '2019-10-24', 1, NULL),
(50, 27, 404.7, 0, 0, 0, 0, 360, 44.7, '2019-10-24', 0, NULL),
(51, 28, 124.9, 0.1, 125, 0, 0, 0, 0, '2019-10-29', 1, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento_pos`
--

CREATE TABLE `pagamento_pos` (
  `seq` int(11) NOT NULL,
  `movimento` int(11) DEFAULT NULL,
  `parcela_data` date DEFAULT NULL,
  `valor_total` double DEFAULT NULL,
  `valor_parcela` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `custo` double DEFAULT '0',
  `margem` double DEFAULT '0',
  `venda` double DEFAULT '0',
  `estoque` double DEFAULT '0',
  `estoque_min` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `codigo`, `descricao`, `custo`, `margem`, `venda`, `estoque`, `estoque_min`) VALUES
(37, '0001', 'Frete', 0, 0, 30, -1, 0),
(20, '0100', 'Luminária sem pintura', 0, 0, 84.9, 8, 1),
(21, '0101', 'Luminária com pintura', 0, 0, 99.9, 3, 1),
(22, '0102', 'Luminária + Interruptor embutido', 0, 0, 114.9, 5, 1),
(2, '1', 'Em aberto', 0, 100, 100, 96, 1),
(18, '100', 'Livro Salmos Branca', 15, 139.33, 35.9, 0, 1),
(19, '101', 'Livro Salmos Vermelha', 15, 139.33, 35.9, 1, 1),
(1, '7891173023001', 'Papel Sulfite 500fls Chamex', 18, 43.89, 25.9, 7, 1),
(4, '7891360544296', 'Lapis grafite 2B     faber castell', 0.89, 91.01, 1.7, 4, 1),
(5, '7891360623106', 'Marca Texto Faber Castell', 1.98, 76.77, 3.5, 4, 1),
(3, '7891360642831', 'Borracha black faber castell', 1.69, 71.6, 2.9, 17, 1),
(17, '7897079072662', 'Lâmpada Taschibra   4.9W', 6.37, 56.99, 10, 2, 1),
(29, '7898521800369', 'A Blibia das descobertas/rosa', 52.06, 47.71, 76.9, 0, 1),
(35, '7898521804169', 'Bíblia de estudo couro sintético azul', 76.74, 56.24, 119.9, 1, 1),
(10, '7898521804251', 'Biblia Sagrada Letra Gigante NTLH Branca', 23.96, 183.39, 67.9, 2, 1),
(8, '7898521811570', 'Biblia Letra Extra Gigante NTLH Marrom', 57.94, 89.68, 109.9, 2, 1),
(30, '7898521812690', 'Minha bíblia do coração', 17.2, 108.72, 35.9, 3, 1),
(33, '7898521812706', 'Escreve e apague atividades divertidas', 15.96, 150, 39.9, 0, 1),
(34, '7899938402580', 'Bíblia letra extragigante preta com Faixa de flores', 70.34, 56.24, 109.9, 0, 1),
(15, '7899938402658', 'Biblia Sagrada Mig-Meg Rosa', 8.06, 146.9, 19.9, 1, 1),
(11, '7899938403334', 'Biblia Sagrada Letra Gigante NTLH Preta', 41.7, 84.41, 76.9, 2, 1),
(32, '7899938404430', 'Bíblia com Harpa Marrom', 70.37, 56.3, 109.99, 1, 1),
(31, '7899938404478', 'Biblía com Harpa Vinho', 70.37, 56.3, 109.99, 1, 1),
(16, '7899938404751', 'Biblia Sagrada Mig-Meg azul', 7.16, 177.93, 19.9, 2, 1),
(28, '9788531110740', 'A Biblia das descobertas/Azul', 52.06, 47.71, 76.9, 1, 1),
(27, '9788531111396', 'Minha biblia de atividades', 26.46, 39.46, 36.9, 1, 1),
(12, '9788531113505', 'Biblia Sagrada Letra Grande Vermelha C/ Cruz Marrom', 19.9, 115.58, 42.9, 1, 1),
(9, '9788531115202', 'Biblia Do Bebe', 9.9, 101.01, 19.9, 3, 1),
(36, '9788531115271', 'Bíblia de estudo Bom Dia', 43.96, 150, 109.9, 1, 1),
(14, '9788531116100', 'Minha Mini Biblia', 15.94, 68.76, 26.9, 1, 1),
(25, '9788531116469', 'Livro pinta com aguá/A criação', 12.74, 24.8, 18.9, 0, 1),
(24, '9788531116476', 'Livro pinta com aguá/A barca de noé', 12.74, 48.35, 18.9, 0, 1),
(23, '9788531116483', 'Livro pinta com aguá/Quando Jesus nasceu', 12.74, 24.8, 18.9, 0, 1),
(26, '9788531116490', 'Livro pinta com aguá/Milagres de jesus', 12.74, 24.8, 18.9, 0, 1),
(13, '9788534919777', 'Biblia de Jerusalém', 45.6, 37.94, 62.9, 1, 1),
(6, '9788555437939', 'Livro Avivados Pelo Espirito Santo', 15, 139.33, 35.9, 1, 1),
(8, '9788555451065', 'Livro A Cruz De Cristo', 15, 139.33, 35.9, 0, 1),
(7, '9788555451089', 'Livro Segredos Da Liderança De Josue', 15, 139.33, 35.9, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `privilegio` tinyint(4) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `senha`, `privilegio`) VALUES
(1, 'GRASI', '1E48C4420B7073BC11916C6C1DE226BB', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda_pdv`
--

CREATE TABLE `venda_pdv` (
  `seq` int(11) NOT NULL,
  `movimento` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `p_codigo` varchar(50) DEFAULT NULL,
  `p_descricao` varchar(200) DEFAULT NULL,
  `p_venda` double DEFAULT NULL,
  `p_qtd` double DEFAULT NULL,
  `cancelado` tinyint(4) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda_pdv`
--

INSERT INTO `venda_pdv` (`seq`, `movimento`, `id_cliente`, `p_codigo`, `p_descricao`, `p_venda`, `p_qtd`, `cancelado`) VALUES
(89, 1, 4, '1', 'Em aberto', 100, 1, 0),
(90, 2, 4, '1', 'Em aberto', 100, 1, 0),
(91, 3, 0, '0101', 'Luminária com pintura', 99.9, 1, 0),
(92, 3, 0, '7897079072662', 'Lânpada Taschibra   4.9W', 10, 1, 0),
(93, 4, 7, '0100', 'Luminária sem pintura', 84.9, 2, 0),
(94, 5, 11, '100', 'Livro Salmos Branca', 35.9, 1, 0),
(95, 5, 11, '9788555451089', 'Livro Segredos Da Liderança De Josue', 35.9, 1, 0),
(96, 5, 11, '7899938402580', 'Bíblia letra extragigante preta com Faixa de flores', 109.9, 1, 0),
(97, 5, 11, '7898521812706', 'Escreve e apague atividades divertidas', 39.9, 1, 0),
(98, 6, 8, '9788531116476', 'Livro pinta com aguá/A barca de noé', 15.9, 1, 0),
(99, 6, 8, '9788531116490', 'Livro pinta com aguá/Milagres de jesus', 15.9, 1, 0),
(100, 7, 9, '9788531115271', 'Bíblia de estudo Bom Dia', 109.9, 1, 0),
(101, 8, 10, '7898521800369', 'A Blibia das descobertas/rosa', 76.9, 1, 0),
(102, 8, 10, '9788531116469', 'Livro pinta com aguá/A criação', 15.9, 1, 0),
(103, 9, 14, '9788531116469', 'Livro pinta com aguá/A criação', 18.9, 1, 0),
(104, 10, 13, '9788531116483', 'Livro pinta com aguá/Quando Jesus nasceu', 18.9, 1, 0),
(105, 11, 12, '9788531116476', 'Livro pinta com aguá/A barca de noé', 18.9, 1, 0),
(106, 12, 15, '9788531116490', 'Livro pinta com aguá/Milagres de jesus', 18.9, 1, 0),
(107, 13, 16, '100', 'Livro Salmos Branca', 35.9, 1, 0),
(108, 13, 16, '101', 'Livro Salmos Vermelha', 35.9, 1, 0),
(109, 13, 16, '9788531115271', 'Bíblia de estudo Bom Dia', 109.9, 1, 0),
(110, 13, 16, '9788555437939', 'Livro Avivados Pelo Espirito Santo', 35.9, 1, 0),
(111, 13, 16, '9788555451065', 'Livro A Cruz De Cristo', 35.9, 1, 0),
(112, 14, 7, '1', 'Em aberto', 100, 1, 0),
(113, 15, 7, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 2, 0),
(114, 16, 17, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 1, 0),
(115, 16, 17, '0101', 'Luminária com pintura', 99.9, 1, 0),
(116, 16, 17, '0001', 'Frete', 30, 1, 0),
(117, 17, 10, '1', 'Em aberto', 100, 1, 0),
(118, 18, 18, '0101', 'Luminária com pintura', 99.9, 1, 0),
(119, 18, 18, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 1, 0),
(120, 19, 19, '0101', 'Luminária com pintura', 99.9, 1, 0),
(121, 19, 19, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 1, 0),
(122, 20, 9, '1', 'Em aberto', 100, 1, 0),
(123, 21, 10, '1', 'Em aberto', 100, 1, 0),
(124, 22, 8, '9788531115202', 'Biblia Do Bebe', 19.9, 1, 0),
(125, 23, 20, '0101', 'Luminária com pintura', 99.9, 2, 0),
(126, 23, 20, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 2, 0),
(127, 24, 21, '9788531113505', 'Biblia Sagrada Letra Grande Vermelha C/ Cruz Marrom', 42.9, 1, 0),
(128, 25, 22, '9788531116483', 'Livro pinta com aguá/Quando Jesus nasceu', 18.9, 1, 0),
(129, 26, 23, '0102', 'Luminária + Interruptor embutido', 124.9, 1, 0),
(130, 26, 23, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 1, 0),
(131, 27, 20, '0102', 'Luminária + Interruptor embutido', 124.9, 3, 0),
(132, 27, 20, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 3, 0),
(133, 28, 22, '0102', 'Luminária + Interruptor embutido', 114.9, 1, 0),
(134, 28, 22, '7897079072662', 'Lâmpada Taschibra   4.9W', 10, 1, 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_movimento`
-- (See below for the actual view)
--
CREATE TABLE `vw_movimento` (
`seq` int(11)
,`movimento` int(11)
,`id_cliente` int(11)
,`prod_cd` varchar(50)
,`prod_desc` varchar(200)
,`prod_valor` double
,`prod_qtd` double
,`total` double
,`troco` double
,`dinheiro` double
,`credito` double
,`debito` double
,`crediario` double
,`desconto` double
,`data` date
,`pago` tinyint(1)
,`data_pago` date
,`cancelado` tinyint(4)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_venda`
-- (See below for the actual view)
--
CREATE TABLE `vw_venda` (
`seq` int(11)
,`movimento` int(11)
,`cliente_id` int(11)
,`cliente_nome` varchar(200)
,`prod_cd` varchar(50)
,`prod_desc` varchar(200)
,`prod_valor` double
,`prod_qtd` double
,`total` double
,`troco` double
,`dinheiro` double
,`credito` double
,`debito` double
,`crediario` double
,`desconto` double
,`data` date
,`pago` tinyint(1)
,`data_pago` date
,`cancelado` tinyint(4)
);

-- --------------------------------------------------------

--
-- Structure for view `vw_movimento`
--
DROP TABLE IF EXISTS `vw_movimento`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_movimento`  AS  select `v`.`seq` AS `seq`,`v`.`movimento` AS `movimento`,`v`.`id_cliente` AS `id_cliente`,`v`.`p_codigo` AS `prod_cd`,`v`.`p_descricao` AS `prod_desc`,`v`.`p_venda` AS `prod_valor`,`v`.`p_qtd` AS `prod_qtd`,`p`.`total` AS `total`,`p`.`troco` AS `troco`,`p`.`dinheiro` AS `dinheiro`,`p`.`credito` AS `credito`,`p`.`debito` AS `debito`,`p`.`crediario` AS `crediario`,`p`.`desconto` AS `desconto`,`p`.`data` AS `data`,`p`.`pago` AS `pago`,`p`.`data_pago` AS `data_pago`,`v`.`cancelado` AS `cancelado` from (`venda_pdv` `v` join `pagamento_pdv` `p` on((`v`.`movimento` = `p`.`movimento`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vw_venda`
--
DROP TABLE IF EXISTS `vw_venda`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_venda`  AS  select `vw_movimento`.`seq` AS `seq`,`vw_movimento`.`movimento` AS `movimento`,`vw_movimento`.`id_cliente` AS `cliente_id`,`cliente`.`nome` AS `cliente_nome`,`vw_movimento`.`prod_cd` AS `prod_cd`,`vw_movimento`.`prod_desc` AS `prod_desc`,`vw_movimento`.`prod_valor` AS `prod_valor`,`vw_movimento`.`prod_qtd` AS `prod_qtd`,`vw_movimento`.`total` AS `total`,`vw_movimento`.`troco` AS `troco`,`vw_movimento`.`dinheiro` AS `dinheiro`,`vw_movimento`.`credito` AS `credito`,`vw_movimento`.`debito` AS `debito`,`vw_movimento`.`crediario` AS `crediario`,`vw_movimento`.`desconto` AS `desconto`,`vw_movimento`.`data` AS `data`,`vw_movimento`.`pago` AS `pago`,`vw_movimento`.`data_pago` AS `data_pago`,`vw_movimento`.`cancelado` AS `cancelado` from (`vw_movimento` join `cliente` on((`vw_movimento`.`id_cliente` = `cliente`.`id`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `boleto`
--
ALTER TABLE `boleto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
  ADD PRIMARY KEY (`seq`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `combo`
--
ALTER TABLE `combo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contas`
--
ALTER TABLE `contas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `controle`
--
ALTER TABLE `controle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor_conta`
--
ALTER TABLE `fornecedor_conta`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor_info`
--
ALTER TABLE `fornecedor_info`
  ADD PRIMARY KEY (`chave`);

--
-- Indexes for table `pagamento_pdv`
--
ALTER TABLE `pagamento_pdv`
  ADD PRIMARY KEY (`seq`);

--
-- Indexes for table `pagamento_pos`
--
ALTER TABLE `pagamento_pos`
  ADD PRIMARY KEY (`seq`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venda_pdv`
--
ALTER TABLE `venda_pdv`
  ADD PRIMARY KEY (`seq`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `boleto`
--
ALTER TABLE `boleto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `caixa`
--
ALTER TABLE `caixa`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `combo`
--
ALTER TABLE `combo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contas`
--
ALTER TABLE `contas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `controle`
--
ALTER TABLE `controle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `fornecedor_conta`
--
ALTER TABLE `fornecedor_conta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `pagamento_pdv`
--
ALTER TABLE `pagamento_pdv`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `pagamento_pos`
--
ALTER TABLE `pagamento_pos`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `venda_pdv`
--
ALTER TABLE `venda_pdv`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
