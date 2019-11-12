-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25-Jun-2019 às 21:30
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.11

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

DROP TABLE IF EXISTS `boleto`;
CREATE TABLE `boleto` (
  `id` int(11) NOT NULL,
  `fornecedor` int(11) DEFAULT NULL,
  `codigo` varchar(44) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `vencimento` date DEFAULT NULL,
  `pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

DROP TABLE IF EXISTS `caixa`;
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

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
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
(0, 'Consumidor Final', NULL, NULL, NULL, 0, NULL, NULL),
(1, 'RAYSLLA BARTOU', NULL, NULL, NULL, 0, '1996-05-22', 0),
(2, 'JONATHAN COMIN RIBEIRO', '092.459.469-16', '(47) 997432978', 'jothbc@gmail.com', 0, '1996-05-22', 0),
(9, 'SAMOEL', '092.459.469-16', NULL, NULL, 0, NULL, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `combo`
--

DROP TABLE IF EXISTS `combo`;
CREATE TABLE `combo` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `produto` varchar(20) DEFAULT NULL,
  `quantidade` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `combo`
--

INSERT INTO `combo` (`id`, `codigo`, `produto`, `quantidade`) VALUES
(11, '321654', '2', 5),
(12, '321654', '4', 1),
(13, '321654', '5', 1),
(14, '321', '1', 1),
(15, '321', '2', 2),
(16, '321', '3', 3),
(22, '789', '2', 5),
(23, '789', '1', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contas`
--

DROP TABLE IF EXISTS `contas`;
CREATE TABLE `contas` (
  `id` int(11) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `vencimento` date DEFAULT NULL,
  `pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contas`
--

INSERT INTO `contas` (`id`, `descricao`, `valor`, `vencimento`, `pago`) VALUES
(1, 'uma conta qualquer', 100, '2019-05-23', '2019-05-23'),
(6, 'test3', 7, '2019-01-10', NULL),
(7, 'conta aleatoria', 102, '2019-12-20', NULL),
(8, 'uma grande', 10000, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `controle`
--

DROP TABLE IF EXISTS `controle`;
CREATE TABLE `controle` (
  `id` int(11) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `controle`
--

INSERT INTO `controle` (`id`, `descricao`, `ativo`) VALUES
(1, 'pdv_automatico', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `chave` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `nome`, `chave`) VALUES
(8, 'SUPERMERCADO CORREIA', 2),
(9, 'FEMSA', 3),
(11, 'VIGOR', 4),
(13, 'ERBS COMERCIO ATACADISTA DE BEBIDAS LTDA', 5),
(14, 'ATACADAO S/A', 6),
(15, 'JONATHAN', 7),
(16, 'PARATI IND COM DE ALIM LTDA', 8),
(17, 'BREAD KING ALIMENTOS EIRELI', 9),
(18, 'BRF S.A', 10),
(19, 'AGRO SANDRI LTDA', 11),
(20, 'DISTRIBUIDORA DE CARNES DISTRIBOI LTDA', 12),
(21, 'DIBAGATIM ALIMENTOS LTDA ME', 13),
(22, 'IRMAOS FOLLE LTDA', 14),
(23, 'BEBIDAS MAX WILHELM LTDA', 15),
(24, 'NEZI DISTRIBUIDORA DE ALIMENTOS LTDA', 16),
(25, 'CENTRO COMERCIAL DE ALIMENTOS LTDA', 17),
(26, 'MCL COM E DIST DE GAS LTDA', 18),
(27, 'SPECHT PRODUTOS ALIMENTICIOS LTDA', 19),
(28, 'INDUSTRIA DE MASSAS ALIMENTICIAS ROSANE EIRELI', 20),
(29, 'TISCOSKI DISTRIBUIDORA COMERCIAL LTDA', 21),
(30, 'DAMA COMERCIO ATACADISTA DE ALIMENTOS LTDA EPP', 22),
(31, 'DOCES CASEIROS NAYANA LTDA ME', 23),
(32, 'BOA MESA COMERCIO DE ALIMENTOS EIRELI', 24),
(33, 'EMBRAST IND E COM DE EMBALAGENS LTDA', 25),
(34, 'BDL DISTRIB E LOGISTICA LTDA', 26),
(36, 'DISTRIBUIDORA MULLER COM E REPRES LTDA', 28),
(37, 'PEDRO MUFFATO E CIA LTDA', 29),
(38, 'RWR LOGISTICA E DISTRIBUICAO LTDA', 30),
(39, 'SPAL IND BRAS BEBIDAS SA', 31),
(40, 'FRISAJO AGRO PECUARIA INDUSTRIAL LTDA', 32),
(41, 'CORDIAL COMERCIO E DISTRIBUICAO LTDA', 33),
(42, 'SEARA ALIMENTOS LTDA', 34),
(43, 'WICKBOLD E NOSSO PAO LTDA', 35),
(44, 'JDC COMERCIO DE CALCADOS LTDA', 36),
(45, 'COOPERATIVA CENTRAL AURORA ALIMENTOS', 37);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor_conta`
--

DROP TABLE IF EXISTS `fornecedor_conta`;
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
(1, 2, 1, '123'),
(3, 3, 0, NULL),
(4, 4, 0, NULL),
(5, 5, 33, '8600'),
(6, 6, 1, '2572'),
(7, 7, 0, NULL),
(8, 8, 237, '0000'),
(9, 9, 748, '7789700000612001119369061726060800261104'),
(10, 10, 237, '23721900117'),
(11, 11, 422, '0020'),
(12, 12, 1, '1748'),
(13, 13, 85, '10100208877041000005'),
(14, 14, 1, '1615'),
(15, 15, 237, '0000'),
(16, 16, 341, '1236029722000'),
(17, 17, 341, '7365252423000'),
(18, 18, 756, '0013069012998181000'),
(19, 19, 237, '0000'),
(20, 20, 237, '0000'),
(21, 21, 341, '7776087160000'),
(22, 22, 85, '0019'),
(23, 23, 1, '2522'),
(24, 24, 85, '0951'),
(25, 25, 237, '2656090000018719'),
(26, 26, 237, '316109000004'),
(27, 5, 85, '0931'),
(28, 28, 1, '2204'),
(29, 29, 1, '0000001914619109154517'),
(30, 30, 237, '0000'),
(31, 31, 341, '2938361074000'),
(32, 32, 237, '81609090000046'),
(33, 33, 341, '4115'),
(34, 34, 1, '2711'),
(35, 35, 237, '2000'),
(36, 36, 237, '0000'),
(37, 37, 1, '2454');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor_info`
--

DROP TABLE IF EXISTS `fornecedor_info`;
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
(2, '20.555.189/0001-96', NULL, '33615974', 'adm.supercorreia@gmail.com', '257393307'),
(6, '75.315.333/0125-49', NULL, '3247-4000', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento_pdv`
--

DROP TABLE IF EXISTS `pagamento_pdv`;
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
(38, 1, 63.09, 0, 34.59, 6, 22.5, 0, 0, '2019-06-22', 1, NULL),
(39, 2, 37.99, 0, 0, 0, 0, 37.99, 0, '2019-06-22', 1, '2019-06-22'),
(40, 3, 68.99, 0, 68.99, 0, 0, 0, 0, '2019-06-22', 1, NULL),
(41, 4, 67.97, 0, 0, 0, 0, 67.97, 0, '2019-06-22', 1, '2019-06-22');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento_pos`
--

DROP TABLE IF EXISTS `pagamento_pos`;
CREATE TABLE `pagamento_pos` (
  `seq` int(11) NOT NULL,
  `movimento` int(11) DEFAULT NULL,
  `parcela_data` date DEFAULT NULL,
  `valor_total` double DEFAULT NULL,
  `valor_parcela` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pagamento_pos`
--

INSERT INTO `pagamento_pos` (`seq`, `movimento`, `parcela_data`, `valor_total`, `valor_parcela`) VALUES
(52, 1, '2019-07-22', 28.5, 2),
(53, 1, '2019-08-22', 28.5, 2),
(54, 1, '2019-09-22', 28.5, 2),
(55, 1, '2019-07-22', 28.5, 4.5),
(56, 1, '2019-08-22', 28.5, 4.5),
(57, 1, '2019-09-22', 28.5, 4.5),
(58, 1, '2019-10-22', 28.5, 4.5),
(59, 1, '2019-11-22', 28.5, 4.5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

DROP TABLE IF EXISTS `produto`;
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
(1, '1', 'luminaria simples', 7, 50, 1, -2, 5),
(13, '11123', 'gato', 50, 20, 60, 2, 2),
(2, '2', 'luminaria trabalhada', 9, 50, 3.5, 11, 10),
(3, '3', 'kit lumi', 8, 50, 1.5, 21, 1),
(9, '321', 'COMBO TEST', NULL, 294.71, 149.99, NULL, NULL),
(10, '321654', 'combo 2', NULL, 175.84, 159.99, NULL, NULL),
(4, '4', 'corda', 7, 0, 1, 14.5, 1),
(5, '5', 'papel', 10, 199.8, 29.98, 2, 12),
(6, '6', 'lapis', 5, 20, 30.99, -24, 1),
(7, '7', 'lampada', 4, 2, 1.02, -2, 2),
(14, '789', 'COMBO DA RAY', NULL, 87.47, 149.98, NULL, NULL),
(8, '8', 'cartolina', 1, 10, 1.1, 15.329999999999998, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
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
(4, 'JONATHAN', '202CB962AC59075B964B07152D234B70', 1),
(5, 'RAYSLLA', '202CB962AC59075B964B07152D234B70', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda_pdv`
--

DROP TABLE IF EXISTS `venda_pdv`;
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
(202, 1, 0, '8', 'cartolina', 1.1, 1, 0),
(203, 1, 0, '7', 'lampada', 1.02, 1, 0),
(204, 1, 0, '6', 'lapis', 30.99, 1, 0),
(205, 1, 0, '5', 'papel', 29.98, 1, 0),
(206, 2, 2, '1', 'luminaria simples', 1, 1, 0),
(207, 2, 2, '2', 'luminaria trabalhada', 3.5, 1, 0),
(208, 2, 2, '3', 'kit lumi', 1.5, 1, 0),
(209, 2, 2, '4', 'corda', 1, 1, 0),
(210, 2, 2, '6', 'lapis', 30.99, 1, 0),
(211, 3, 0, '1', 'luminaria simples', 1, 1, 0),
(212, 3, 0, '2', 'luminaria trabalhada', 3.5, 1, 0),
(213, 3, 0, '3', 'kit lumi', 1.5, 1, 0),
(214, 3, 0, '4', 'corda', 1, 1, 0),
(215, 3, 0, '5', 'papel', 29.98, 1, 0),
(216, 3, 0, '6', 'lapis', 30.99, 1, 0),
(217, 3, 0, '7', 'lampada', 1.02, 1, 0),
(218, 4, 2, '1', 'luminaria simples', 1, 1, 0),
(219, 4, 2, '2', 'luminaria trabalhada', 3.5, 1, 0),
(220, 4, 2, '3', 'kit lumi', 1.5, 1, 0),
(221, 4, 2, '4', 'corda', 1, 1, 0),
(222, 4, 2, '5', 'papel', 29.98, 1, 0),
(223, 4, 2, '6', 'lapis', 30.99, 1, 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_movimento`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `vw_movimento`;
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
DROP VIEW IF EXISTS `vw_venda`;
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `caixa`
--
ALTER TABLE `caixa`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `combo`
--
ALTER TABLE `combo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `contas`
--
ALTER TABLE `contas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `controle`
--
ALTER TABLE `controle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `fornecedor_conta`
--
ALTER TABLE `fornecedor_conta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `pagamento_pdv`
--
ALTER TABLE `pagamento_pdv`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `pagamento_pos`
--
ALTER TABLE `pagamento_pos`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `venda_pdv`
--
ALTER TABLE `venda_pdv`
  MODIFY `seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=224;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
